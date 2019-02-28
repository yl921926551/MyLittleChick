package cn.ly.mlc.web.entity.params;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import topdeep.zhst.entity.params.ZhstApplicationParam;

/**
 * 
 * @author shidewen
 *
 */
@Component
public class WebParam extends ZhstApplicationParam {

	@Value("#{application['wechat-skin']?:'default'}")
	private String wechatSkin;

	@Value("#{application['wechat-theme']?:''}")
	private String wechatTheme;

	@Value("#{application['phone-skin']?:'default'}")
	private String phoneSkin;

	@Value("#{application['phone-theme']?:''}")
	private String phoneTheme;

	@Value("#{application['pc-skin']?:'default'}")
	private String pcSkin;

	@Value("#{application['pc-theme']?:''}")
	private String pcTheme;

	@Value("#{application['version']?:''}")
	private String version;

	/**
	 * adminControlIp
	 */
	@Value("#{application['adminControlIp']}")
	private String adminControlIp;

	@Value("#{application['insertVisitLog']?:false}")
	private boolean insertVisitLog;

	public String getAdminControlIp() {
		return adminControlIp;
	}

	public void setAdminControlIp(String adminControlIp) {
		this.adminControlIp = adminControlIp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the insertVisitLog
	 */
	public boolean isInsertVisitLog() {
		return insertVisitLog;
	}

	/**
	 * @param insertVisitLog the insertVisitLog to set
	 */
	public void setInsertVisitLog(boolean insertVisitLog) {
		this.insertVisitLog = insertVisitLog;
	}

	/**
	 * @return the wechatSkin
	 */
	public String getWechatSkin() {
		return wechatSkin;
	}

	/**
	 * @param wechatSkin the wechatSkin to set
	 */
	public void setWechatSkin(String wechatSkin) {
		this.wechatSkin = wechatSkin;
	}

	/**
	 * @return the wechatTheme
	 */
	public String getWechatTheme() {
		return wechatTheme;
	}

	/**
	 * @param wechatTheme the wechatTheme to set
	 */
	public void setWechatTheme(String wechatTheme) {
		this.wechatTheme = wechatTheme;
	}

	/**
	 * @return the phoneSkin
	 */
	public String getPhoneSkin() {
		return phoneSkin;
	}

	/**
	 * @param phoneSkin the phoneSkin to set
	 */
	public void setPhoneSkin(String phoneSkin) {
		this.phoneSkin = phoneSkin;
	}

	/**
	 * @return the phoneTheme
	 */
	public String getPhoneTheme() {
		return phoneTheme;
	}

	/**
	 * @param phoneTheme the phoneTheme to set
	 */
	public void setPhoneTheme(String phoneTheme) {
		this.phoneTheme = phoneTheme;
	}

	/**
	 * @return the pcSkin
	 */
	public String getPcSkin() {
		return pcSkin;
	}

	/**
	 * @param pcSkin the pcSkin to set
	 */
	public void setPcSkin(String pcSkin) {
		this.pcSkin = pcSkin;
	}

	/**
	 * @return the pcTheme
	 */
	public String getPcTheme() {
		return pcTheme;
	}

	/**
	 * @param pcTheme the pcTheme to set
	 */
	public void setPcTheme(String pcTheme) {
		this.pcTheme = pcTheme;
	}

}
