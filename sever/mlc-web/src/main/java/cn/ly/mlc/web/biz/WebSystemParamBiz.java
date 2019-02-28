package cn.ly.mlc.web.biz;

import java.util.HashMap;
import java.util.Map;

import cn.ly.mlc.web.entity.params.WebParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topdeep.zhst.biz.common.impl.ZhstSystemParamBiz;
import topdeep.zhst.entity.constant.EnumType.SiteType;
import cn.ly.mlc.web.entity.params.WebParam;

/**
 * 
 * @author shidewen
 * 
 */
@Service("webSystemParamBiz")
public class WebSystemParamBiz extends ZhstSystemParamBiz {

	@Autowired
	private WebParam webParam;

	private Map<String, SiteType> hostMap;
	private Map<SiteType, String> hostSkinMap;


	/**
	 * @return the webParam
	 */
	public WebParam getWebParam() {
		return webParam;
	}

	private void addHostMap(String hostConfig, SiteType siteType, Map<String, SiteType> hostMap) {
		String[] hostAry = hostConfig.toLowerCase().split(",");
		for (String host : hostAry) {
			if (!hostMap.containsKey(host)) {
				hostMap.put(host, siteType);
			}
		}
	}

	private void initHostMap() {
		hostMap = new HashMap<String, SiteType>();
		hostSkinMap = new HashMap<SiteType, String>();
		addHostMap(getZhstApplicationParam().getPortHostName(), SiteType.WWW, hostMap);
		addHostMap(getZhstApplicationParam().getPhoneHostName(), SiteType.M, hostMap);
		addHostMap(getZhstApplicationParam().getAppHostName(), SiteType.App, hostMap);
		addHostMap(getZhstApplicationParam().getEtradeHostName(), SiteType.ETRADE, hostMap);
		addHostMap(getZhstApplicationParam().getWgHostName(), SiteType.WG, hostMap);
		addHostMap(getZhstApplicationParam().getWxHostName(), SiteType.WX, hostMap);

		hostSkinMap.put(SiteType.App, getZhstApplicationParam().getAppSkin());
		hostSkinMap.put(SiteType.ETRADE, getZhstApplicationParam().getEtradeSkin());
		hostSkinMap.put(SiteType.M, getZhstApplicationParam().getPhoneSkin());
		hostSkinMap.put(SiteType.WG, getZhstApplicationParam().getWgSkin());
		hostSkinMap.put(SiteType.WWW, getZhstApplicationParam().getPortSkin());
		hostSkinMap.put(SiteType.WX, getZhstApplicationParam().getWxSkin());
	}

	public void init() {
		super.init();
		initHostMap();
	}

	public SiteType getSiteType(String hostName) {
		if (hostMap.containsKey(hostName.toLowerCase())) {
			return hostMap.get(hostName.toLowerCase());
		}
		if (hostMap.containsKey(getCommonApplicationParam().getDefaultSite())) {
			return hostMap.get(getCommonApplicationParam().getDefaultSite());
		}
		return SiteType.M;
	}

	public String getSiteSkin(SiteType siteType) {
		if (hostSkinMap.containsKey(siteType)) {
			return hostSkinMap.get(siteType);
		}
		return "phone";
	}

	public Map<String, SiteType> getHostMap() {
		return hostMap;
	}

	public Map<SiteType, String> getHostSkinMap() {
		return hostSkinMap;
	}

}
