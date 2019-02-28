package cn.ly.mlc.mg.action.base;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Map;

import cn.ly.mlc.mg.entity.response.BaseResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import common.cache2.Cache;
import common.util.HttpUtils;
import common.util.StringUtils;
import topdeep.common.biz.common.CommonSystemBiz;
import topdeep.common.entity.params.CommonWebPageParam;
import topdeep.common.mg.biz.common.CommonMgSystemParamBiz;
import topdeep.zhst.biz.common.ZhstSystemBiz;
import topdeep.zhst.biz.common.impl.ZhstSystemParamBiz;
import topdeep.zhst.dao.rcs.RcsDao;
import cn.ly.mlc.mg.biz.WebUserRuntimeBiz;
import cn.ly.mlc.mg.entity.response.BaseResponse;
import cn.ly.mlc.mg.util.BcpExcelUtil;

public class BaseAction {
	/** 重定向 **/
	protected static final String REDIRECT = "redirect:";

	protected static Log logger = LogFactory.getLog(BaseAction.class);

	@Autowired
	@Qualifier("commonMgSystemParamBiz")
	protected CommonMgSystemParamBiz commonMgSystemParamBiz;

	@Autowired
	@Qualifier("commonSystemBiz")
	protected CommonSystemBiz commonSystemBiz;
	
	@Autowired
	private CommonWebPageParam commonWebParam;

	@Autowired
	@Qualifier("baseInfoCache")
	protected Cache baseInfoCache;

	@Autowired
	@Qualifier("cache30")
	protected Cache cache30;

	@Autowired
	@Qualifier("webUserRuntimeBiz")
	protected WebUserRuntimeBiz webUserRuntimeBiz;

	@Autowired
	@Qualifier("zhstSystemBiz")
	protected ZhstSystemBiz zhstSystemBiz;

	@Autowired
	@Qualifier("zhstSystemParamBiz")
	protected ZhstSystemParamBiz zhstSystemParamBiz;

	@Autowired
	@Qualifier("bcpExcelUtil")
	protected BcpExcelUtil bcpExcelUtil;

	@Autowired
	@Qualifier("rcsDao")
	protected RcsDao rcsDao;

	protected DecimalFormat df2 = new DecimalFormat("####0.00");

	public boolean execute(topdeep.common.mg.entity.request.BaseRequest req,
			topdeep.common.mg.entity.response.BaseResponse res) {
		return execute(req, res, false);
	}

	public boolean execute(topdeep.common.mg.entity.request.BaseRequest req,
			topdeep.common.mg.entity.response.BaseResponse res, boolean needLogin, boolean isAjaxRequest) {
		req.setAjaxRequest(isAjaxRequest);
		res.setResult(true, "");
		res.setSkin(commonMgSystemParamBiz.getCommonMgApplicationParam().getSkin());
		res.setMainSkin(commonMgSystemParamBiz.getCommonMgApplicationParam().getMainSkin());
		res.setLoginName(webUserRuntimeBiz.getLoginUserName());
		res.setVersion(commonMgSystemParamBiz.getCommonMgApplicationParam().getVersion());
		res.getTemplate().setMain(commonMgSystemParamBiz.getCommonMgApplicationParam().getMainTemplate());
		res.getTemplate().setNav(commonMgSystemParamBiz.getCommonMgApplicationParam().getNavTemplate());
		res.getTemplate().setHead(commonMgSystemParamBiz.getCommonMgApplicationParam().getHeadTemplate());
		res.getTemplate().setPage(commonMgSystemParamBiz.getCommonMgApplicationParam().getPageTemplate());
		res.setNavQueryUrl(commonMgSystemParamBiz.getCommonMgApplicationParam().getNavQueryUrl());
		res.setAppName(commonMgSystemParamBiz.getCommonMgApplicationParam().getAppName());
		res.setVersion(commonWebParam.getVersion());
		req.checkInput(res);

		String logoUrl = commonMgSystemParamBiz.getCommonMgApplicationParam().getLogo();
		if (StringUtils.isNullOrEmpty(logoUrl)) {
			logoUrl = "/static/common/skin/" + res.getMainSkin() + "/images/logo_lg.png";
		}
		res.setLogo(logoUrl);

		if (needLogin && !webUserRuntimeBiz.isLogin()) {
			String url = "/h/login.action";
			if (!isAjaxRequest && !StringUtils.isNullOrEmpty(webUserRuntimeBiz.getCurrentVisitUrl())) {
				url += "?returnUrl=" + HttpUtils.urlEncode(webUserRuntimeBiz.getCurrentVisitUrl());
			}
			res.setRedirectUrl(url);
		}
		return res.isSuccess();
	}

	public boolean execute(topdeep.common.mg.entity.request.BaseRequest req,
			topdeep.common.mg.entity.response.BaseResponse res, boolean isAjaxRequest) {
		return execute(req, res, true, isAjaxRequest);
	}

	/**
	 * 处理用户选中的权限值,用户选中的权限值是模块加单选的值，放到数据库的时候合并一下，省点地方
	 * 
	 * @param userSelectPrivileges
	 * @return
	 */
	public String dealUploadPrivileges(String userSelectPrivileges) {
		if (StringUtils.isNullOrEmpty(userSelectPrivileges)) {
			return "";
		}
		Map<Integer, Integer> funcMap = new Hashtable<Integer, Integer>();
		String[] values = userSelectPrivileges.split(",");
		for (String item : values) {
			if (StringUtils.isNullOrEmpty(item)) {
				continue;
			}
			int value = Integer.parseInt(item);
			int func = value >> 8;
			int operateValue = value & 0xff;
			if (funcMap.containsKey(func)) {
				int oldValue = funcMap.get(func);
				operateValue = operateValue | oldValue;
				funcMap.remove(func);
			}
			funcMap.put(func, operateValue);
		}
		// 此时Map中是整理过的权限值，输出即可
		String ret = "";
		for (Integer func : funcMap.keySet()) {
			int operateValue = funcMap.get(func);
			int value = (func << 8) + operateValue;
			if (!StringUtils.isNullOrEmpty(ret)) {
				ret += ",";
			}
			ret += value;
		}
		return ret;
	}

	protected boolean checkPrivilege(BaseResponse res, int func, int operate) {
		boolean hasPrivilege = webUserRuntimeBiz.hasPrivilege(func, operate);
		if (!hasPrivilege) {
			res.setResult(false, "没有管理权限");
			res.setRedirectUrl("/default/system/privileges-check-fail");
		}
		return res.isSuccess();
	}

	public String encodeId(String id) {
		String result = id;
		try {
			result = URLEncoder.encode(id, "utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	public String decodeId(String id) {
		String result = id;
		try {
			result = URLDecoder.decode(id, "utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * } formatNull:(将null转为空串). <br/>
	 * 
	 * @author develop
	 * @param str
	 * @return
	 * 
	 */
	protected String formatNull(String str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}

	public Cache getBaseInfoCache() {
		return baseInfoCache;
	}

	public void setBaseInfoCache(Cache baseInfoCache) {
		this.baseInfoCache = baseInfoCache;
	}

	/**
	 * type 0 缩略图 1 大图(原图)
	 * 
	 * @param relativePath
	 * @param type
	 * @return ZhstBizImplBase queryPicAccessUrl
	 */
	protected String queryPicAccessUrl(String relativePath, int type) {
		String url = "";
		if (StringUtils.isNullOrEmpty(relativePath)) {
			return relativePath;
		}
		String serverUrlPrefix = this.zhstSystemParamBiz.getZhstApplicationParam().getServerUrlPrefix();
		if (StringUtils.isNullOrEmpty(serverUrlPrefix)) {
			return relativePath;
		}
		if (!serverUrlPrefix.endsWith(File.separator)) {
			serverUrlPrefix += File.separator;
		}
		url = serverUrlPrefix + relativePath;
		if (type == 0) {
			url = serverUrlPrefix + relativePath.replace(File.separator + "oriImg" + File.separator, File.separator + "thumbnailImg" + File.separator);
		}
		return url;
	}
}
