package cn.ly.mlc.web.action.base;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import topdeep.zhst.biz.common.impl.ZhstSystemParamBiz;
import cn.ly.mlc.web.biz.WebSystemParamBiz;

/**
 * @author shidewen
 * 
 */
@Controller
public class BaseAction {

	protected Log logger = LogFactory.getLog(getClass());

	@Autowired
	@Qualifier("webSystemParamBiz")
	protected WebSystemParamBiz webSystemParamBiz;

	@Autowired
	@Qualifier("zhstSystemParamBiz")
	protected ZhstSystemParamBiz zhstSystemParamBiz;

	protected String serverUrlPrefix = "/";

	public String getVersion() {
		if ("".equals(webSystemParamBiz.getWebParam().getVersion())) {
			return "" + new Date().getTime();
		}
		return webSystemParamBiz.getWebParam().getVersion();
	}

	public String getServerUrlPrefix() {
		return serverUrlPrefix;
	}

	public void setServerUrlPrefix(String serverUrlPrefix) {
		this.serverUrlPrefix = serverUrlPrefix;
	}

}
