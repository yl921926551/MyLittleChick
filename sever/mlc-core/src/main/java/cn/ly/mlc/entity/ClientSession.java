package cn.ly.mlc.entity;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author shidewen
 *
 */
public class ClientSession implements Serializable{
	
	private static Log logger = LogFactory.getLog(ClientSession.class);
	
	private String userId;
	
	private String userMobile;
	
	private String registerMobile;
	
	private String userName;
	
	private String clientId;
	
	private String clientType;
	
	private String dynamicSignKey;

	private String dynamicEncKey;
	
	private boolean login;
	
	private String clientIp;
	
	/**
	 * 小程序用户OPENID
	 */
	private String openId;

	/**
	 * 1：借款人 5:平台员工 6：积分用户
	 */
	private String userType;

	/**
	 * 是否是员工
	 */
	private boolean staffFlag = false;

	public ClientSession(){
		logger.debug("ClientSession Created!");
	}

	public void clearSession(){
		this.userId = "";
		this.userMobile = "";
		this.clientType = "";
		this.userName = "";
		this.registerMobile = "";
		this.login = false;
		this.userType = "";
		this.clientIp = "";
		this.openId = "";
		this.staffFlag = false;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userMobile
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @param userMobile the userMobile to set
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientType
	 */
	public String getClientType() {
		return clientType;
	}

	/**
	 * @param clientType the clientType to set
	 */
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	/**
	 * @return the dynamicEncryKey
	 */
	public String getDynamicEncKey() {
		return dynamicEncKey;
	}

	/**
	 * @param dynamicEncryKey the dynamicEncryKey to set
	 */
	public void setDynamicEncKey(String dynamicEncKey) {
		this.dynamicEncKey = dynamicEncKey;
	}

	/**
	 * @return the dynamicSignKey
	 */
	public String getDynamicSignKey() {
		return dynamicSignKey;
	}


	/**
	 * @param dynamicSignKey the dynamicSignKey to set
	 */
	public void setDynamicSignKey(String dynamicSignKey) {
		this.dynamicSignKey = dynamicSignKey;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the registerMobile
	 */
	public String getRegisterMobile() {
		return registerMobile;
	}

	/**
	 * @param registerMobile the registerMobile to set
	 */
	public void setRegisterMobile(String registerMobile) {
		this.registerMobile = registerMobile;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}

	/**
	 * @param clientIp the clientIp to set
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * @return the staffFlag
	 */
	public boolean isStaffFlag() {
		return staffFlag;
	}

	/**
	 * @param staffFlag the staffFlag to set
	 */
	public void setStaffFlag(boolean staffFlag) {
		this.staffFlag = staffFlag;
	}
	
}
