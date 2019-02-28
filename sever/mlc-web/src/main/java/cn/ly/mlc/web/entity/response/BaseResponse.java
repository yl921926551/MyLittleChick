package cn.ly.mlc.web.entity.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.util.StringUtils;

public class BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Log logger = LogFactory.getLog(BaseResponse.class);
	
	/**
	 * 执行结果是否成功
	 */
	private boolean success = true;
	
	/**
	 * 执行结果提示信息 
	 */
	private String tipMessage = "";
	/**
	 * 需要跳转的地址
	 */
	private String redirectUrl = "";
	private String skin = "";
	private String theme = "";
	private String siteType;
	private String customerName = "";
	private String version;
	private String title;
	private boolean login = false;
	

	private String statisPath;

	private String redirectServerUrl="";

	
	/**
	 * 用户是否绑定微信了
	 */
	private String binded = "false";


	/**
	 * 静态页相对路径
	 */
	private String htmlVisitPath = "";

	/**
	 * 手机号
	 */
	private String mobileNo;
	
	/**
	 * 密码是否正确
	 */
	private boolean isRightPwd = true;

    /**
     * 执行结果其它自定义数据 
     */
    private Map<String,Object> data=new  HashMap<String,Object>();

	/**
	 * 显示标志
	 */
	private String showFlag;
	
	/**
	 * 错误码 01重新登录
	 */
	protected String errCode; 
	
	private String webAppIp;

    public boolean needRedirect(){
    	return !StringUtils.isNullOrEmpty(redirectUrl);
    }
    
    public String getTarget(String template){
    	if(needRedirect()){
    		if(!getRedirectUrl().startsWith("https://") && !getRedirectUrl().startsWith("http://")){
    			setRedirectUrl(getRedirectServerUrl() + getRedirectUrl());
    		}
    		logger.debug("redirect: "+  getRedirectUrl());
			return "redirect:"+  getRedirectUrl();	
    	}else{
    		if(StringUtils.isNullOrEmpty(getTipMessage())){
    			logger.debug(getTipMessage());	
    		}
    		return getSkin()+template;
    	}
    }
    
	public Map<String, Object> getData() {
		return data;
	}
	
	public void setResult(boolean isSuccess, String tipMsg){
		success = isSuccess;
		tipMessage += tipMsg;
	}
	
	public void checkStringValue(String value, String tipMsg) {
		if (StringUtils.isNullOrEmpty(value)) {
			setResult(false, tipMsg);
		}
	}
	
	public void checkStringEqual(String value1, String value2, String tipMsg){
		if(StringUtils.isNullOrEmpty(value1) || StringUtils.isNullOrEmpty(value2) || !value1.equals(value2)){
			setResult(false, tipMsg);
		}
	}
	public void checkStringNotEqual(String value1, String value2, String tipMsg){
		if(StringUtils.isNullOrEmpty(value1) || StringUtils.isNullOrEmpty(value2) || value1.equals(value2)){
			setResult(false, tipMsg);
		}
	}
	public void checkNull(Object value, String tipMsg){
		if(value == null){
			setResult(false, tipMsg);
		}
	}

	public void checkStringEmpty(String value, String tipMsg){
		if(StringUtils.isNullOrEmpty(value)){
			setResult(false, tipMsg);
		}
	}
	
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the tipMessage
	 */
	public String getTipMessage() {
		return tipMessage;
	}

	/**
	 * @param tipMessage the tipMessage to set
	 */
	public void setTipMessage(String tipMessage) {
		this.tipMessage = tipMessage;
	}

	/**
	 * @return the skin
	 */
	public String getSkin() {
		return skin;
	}

	/**
	 * @param skin the skin to set
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the redirectUrl
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}
	/**
	 * @param redirectUrl the redirectUrl to set
	 */
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBinded() {
		return binded;
	}

	public void setBinded(String binded) {
		this.binded = binded;
	}

	/**
	 * @return the siteType
	 */
	public String getSiteType() {
		return siteType;
	}

	public String getStatisPath() {
		return statisPath;
	}

	public void setStatisPath(String statisPath) {
		this.statisPath = statisPath;
	}

	/**
	 * @param siteType the siteType to set
	 */
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	
	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getRedirectServerUrl() {
		return redirectServerUrl;
	}

	public void setRedirectServerUrl(String redirectServerUrl) {
		this.redirectServerUrl = redirectServerUrl;
	}

	public String getHtmlVisitPath() {
		return htmlVisitPath;
	}

	public void setHtmlVisitPath(String htmlVisitPath) {
		this.htmlVisitPath = htmlVisitPath;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isRightPwd() {
		return isRightPwd;
	}

	public void setRightPwd(boolean isRightPwd) {
		this.isRightPwd = isRightPwd;
	}

	public String getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return the webAppIp
	 */
	public String getWebAppIp() {
		return webAppIp;
	}

	/**
	 * @param webAppIp the webAppIp to set
	 */
	public void setWebAppIp(String webAppIp) {
		this.webAppIp = webAppIp;
	}


}
