package cn.ly.mlc.entity.params;

import cn.ly.mlc.entity.annotation.EntityAttribute;
import cn.ly.mlc.entity.annotation.EntityFieldAttribute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import topdeep.common.entity.params.BaseSystemParam;
import cn.ly.mlc.entity.annotation.EntityAttribute;
import cn.ly.mlc.entity.annotation.EntityFieldAttribute;

/**
 * 
 * @author shidewen
 *
 */
@Component
@EntityAttribute(name="系统参数",desc="系统参数")
public class MlcApplicationParam extends BaseSystemParam {

	@Value("#{application['zhst.webAppIp']?:'192.168.0.115'}")
	@EntityFieldAttribute(name="web端客户端IP地址",desc="web端客户端IP地址",type="String")
	private String zhstWebAppIp;

	@Value("#{application['host.port']?:'zhst-www.topdeep.com'}")
	@EntityFieldAttribute(name="portHostName",desc="portHostName",type="String")
	private String portHostName;
	
	@Value("#{application['host.phone']?:'zhst-m.topdeep.com'}")
	@EntityFieldAttribute(name="phoneHostName",desc="phoneHostName",type="String")
	private String phoneHostName;
	
	@Value("#{application['host.app']?:'zhst-app.topdeep.com'}")
	@EntityFieldAttribute(name="appHostName",desc="appHostName",type="String")
	private String appHostName;
	
	@Value("#{application['host.etrade']?:'zhst-etrade.topdeep.com'}")
	@EntityFieldAttribute(name="etradeHostName",desc="etradeHostName",type="String")
	private String etradeHostName;
	
	@Value("#{application['host.wg']?:'zhst-wg.topdeep.com'}")
	@EntityFieldAttribute(name="wgHostName",desc="wgHostName",type="String")
	private String wgHostName;
	
	@Value("#{application['host.wx']?:'zhst-wx.topdeep.com'}")
	@EntityFieldAttribute(name="wxHostName",desc="wxHostName",type="String")
	private String wxHostName;

	@Value("#{application['skin.port']?:'www'}")
	@EntityFieldAttribute(name="portSkin",desc="portSkin",type="String")
	private String portSkin;
	
	@Value("#{application['skin.phone']?:'phone'}")
	@EntityFieldAttribute(name="phoneSkin",desc="phoneSkin",type="String")
	private String phoneSkin;
	
	@Value("#{application['skin.app']?:'phone'}")
	@EntityFieldAttribute(name="appSkin",desc="appSkin",type="String")
	private String appSkin;
	
	@Value("#{application['skin.etrade']?:'web'}")
	@EntityFieldAttribute(name="etradeSkin",desc="etradeSkin",type="String")
	private String etradeSkin;
	
	@Value("#{application['skin.wg']?:'phone'}")
	@EntityFieldAttribute(name="wgSkin",desc="wgSkin",type="String")
	private String wgSkin;
	
	@Value("#{application['skin.wx']?:'phone'}")
	@EntityFieldAttribute(name="wxSkin",desc="wxSkin",type="String")
	private String wxSkin;

	/**
	 * 访问来源判断方法(0:域名，1:contextPath)
	 */
	@Value("#{application['zhst.siteTypeFlag']?:'0'}")
	@EntityFieldAttribute(name="访问来源判断方法",desc="0:域名，1:contextPath",type="String")
	protected String siteTypeFlag;

	/**
	 * 推送应用服务器编号 clientApp
	 */
	@Value("#{application['message.push.clientApp']?:'clientApp'}")
	@EntityFieldAttribute(name="推送应用服务器编号",desc="推送应用服务器编号",type="String")
	private String pushMessageClientApp = "clientApp";

	@Value("#{application['message.push.topic']?:'topic'}")
	@EntityFieldAttribute(name="消息推送pushMessageTopic",desc="消息推送pushMessageTopic",type="String")
	private String pushMessageTopic = pushMessageClientApp;

	@Value("#{application['message.push.version']?:'1.0.1'}")
	@EntityFieldAttribute(name="消息推送版本pushMessageVersion",desc="消息推送版本pushMessageVersion",type="String")
	private String pushMessageVersion = "1.0.1";

	@Value("#{application['message.push.encrypt']?:'MTIzNDU2Nzg5MDEyMzQ1Ng=='}")
	@EntityFieldAttribute(name="消息推送pushMessagEencrypt",desc="消息推送pushMessagEencrypt",type="String")
	private String pushMessagEencrypt = "MTIzNDU2Nzg5MDEyMzQ1Ng==";

	@Value("#{application['message.push.file.pwd']?:'12345678'}")
	@EntityFieldAttribute(name="消息推送pushMessagePwd",desc="消息推送pushMessagePwd",type="String")
	private String pushMessagePwd = "12345678";

	@Value("#{application['message.push.filename']?:'/home/develop/mock.pfx'}")
	@EntityFieldAttribute(name="消息推送pushMessageFilename",desc="消息推送pushMessageFilename",type="String")
	private String pushMessageFilename = "/home/develop/mock.pfx";

	@Value("#{application['message.push.publicfilename']?:'/home/develop/mock.cer'}")
	@EntityFieldAttribute(name="消息推送pushMessagePublicFilename",desc="消息推送pushMessagePublicFilename",type="String")
	private String pushMessagePublicFilename = "/home/develop/mock.cer";

	@Value("#{application['message.push.pushHost']?:'http://localhost:8080/push-servlet/pushMessageServlet'}")
	@EntityFieldAttribute(name="消息推送pushMessagepushHost",desc="消息推送pushMessagepushHost",type="String")
	private String pushMessagepushHost = "http://localhost:8080/push-servlet/pushMessageServlet";

	/**
	 * 防止重放攻击，是否校验请求的ID和时间
	 */
	@Value("#{application['zhst.checkIdAndTime']?:true}")
	@EntityFieldAttribute(name="防止重放攻击，是否校验请求的ID和时间",desc="true或者false",type="boolean")
	private boolean checkIdAndTime;

	/**
	 * 请求ID缓存时间
	 */
	@Value("#{application['zhst.checkTimestampDiff']?:1800000}")
	@EntityFieldAttribute(name="防止重放攻击，是否校验请求的ID和时间",desc="毫秒数",type="int")
	private int checkTimestampDiff;

	/**
	 * 服务器地址前缀
	 */
	@Value("#{application['zhst.serverUrlPrefix']?:''}")
	@EntityFieldAttribute(name="服务器地址前缀",desc="服务器地址前缀",type="String")
	private String serverUrlPrefix;

	@Value("#{application['phoneClientConfigFile']?:''}")
	@EntityFieldAttribute(name="phoneClientConfigFile",desc="phoneClientConfigFile",type="String")
	private String phoneClientConfigFile;

	@Value("#{application['versionServiceUrl']?:''}")
	@EntityFieldAttribute(name="versionServiceUrl",desc="versionServiceUrl",type="String")
	private String versionServiceUrl;

	@Value("#{application['funcServiceUrl']?:''}")
	@EntityFieldAttribute(name="funcServiceUrl",desc="funcServiceUrl",type="String")
	private String funcServiceUrl;

	/**
	 * 是否发送真实短信(0、使用，1、不使用)
	 */
	@Value("#{application['zhst.useRealMsg']?:'0'}")
	@EntityFieldAttribute(name="是否发送真实短信",desc="0、使用，1、不使用",type="String")
	private String useRealMsg;

	@Value("#{application['zhst.smsCodeCountLimit']?:10}")
	@EntityFieldAttribute(name="smsCodeCountLimit",desc="smsCodeCountLimit",type="Integer")
	private Integer smsCodeCountLimit;

	@Value("#{application['zhst.staticZipSourcesDir']?:''}")
	@EntityFieldAttribute(name="staticZipSourcesDir",desc="staticZipSourcesDir",type="String")
	private String staticZipSourcesDir;

	/**
	 * 是否动态生成图片验证码(0、是，1、否)
	 */
	@Value("#{application['zhst.generateImgValidCodeDynamic']?:'0'}")
	@EntityFieldAttribute(name="是否动态生成图片验证码",desc="0、是，1、否",type="String")
	private String generateImgValidCodeDynamic;

	/**
	 * 图形验证码可验证次数
	 */
	@Value("#{application['zhst.imgValidCodeValidationTimes']?:3}")
	@EntityFieldAttribute(name="图形验证码可验证次数",desc="图形验证码可验证次数",type="Integer")
	private Integer imgValidCodeValidationTimes;

	@Value("#{application['zhst.questionnaireId']?:''}")
	@EntityFieldAttribute(name="问卷标识ID",desc="问卷标识ID",type="String")
	private String questionnaireId;

	/**
	 * 资讯分类名字
	 */
	@Value("#{application['zhst.homeBannerCatalogName']?:'homeBanner'}")
	@EntityFieldAttribute(name="借款人客户端APP首页banner分类名称",desc="借款人客户端APP首页banner分类名称",type="String")
	private String homeBannerCatalogName;

	@Value("#{application['zhst.infoBannerCatalogName']?:'infoBanner'}")
	@EntityFieldAttribute(name="借款人客户端APP首页资讯banner分类名称",desc="借款人客户端APP首页资讯banner分类名称",type="String")
	private String infoBannerCatalogName;

	@Value("#{application['zhst.infoListCatalogName']?:'infoCatalog'}")
	@EntityFieldAttribute(name="借款人客户端APP首页资讯列表分类名称",desc="借款人客户端APP首页资讯列表分类名称",type="String")
	private String infoListCatalogName;

	/**
	 * 还款天数
	 */
	@Value("#{application['zhst.sendRepaymentDayNum']?:'2'}")
	@EntityFieldAttribute(name="还款天数",desc="还款天数",type="Integer")
	private Integer sendRepaymentDayNum;

	/**
	 * 收益提取税率
	 */
	@Value("#{application['zhst.incomeWithDrawTaxRate']?:0.01}")
	@EntityFieldAttribute(name="收益提取税率",desc="收益提取税率",type="Double")
	private Double incomeWithDrawTaxRate = 0.01;

	/**
	 * 借款人收益提取税率
	 */
	@Value("#{application['zhst.borrowerIncomeWithDrawTaxRate']?:0.01}")
	@EntityFieldAttribute(name="借款人收益提取税率",desc="借款人收益提取税率",type="Double")
	private Double borrowerIncomeWithDrawTaxRate = 0.01;

	/**
	 * 中国地区代码
	 */
	@Value("#{application['zhst.chinaAreaCode']?:'*'}")
	@EntityFieldAttribute(name="中国地区代码",desc="中国地区代码",type="String")
	private String chinaAreaCode;
	
	/**
	 * 短信发送接口实现
	 */
	@Value("#{application['zhst.sms.choose']?:'1'}")
	@EntityFieldAttribute(name="短信发送接口实现",desc="1或0",type="String")
	private String smsChoose;

	/**
	 * 验证短信模版
	 */
	@Value("#{application['zhst.sms.validate.templateid']?:''}")
	@EntityFieldAttribute(name="验证短信模版标识ID",desc="验证短信模版标识ID",type="String")
	private String smsValidateTemplateid;

	/**
	 * 通知短信模版
	 */
	@Value("#{application['zhst.sms.notice.templateid']?:''}")
	@EntityFieldAttribute(name="通知短信模版标识ID",desc="通知短信模版标识ID",type="String")
	private String smsNoticeTemplateid;

	/**
	 * 贷款信审支付地址
	 */
	@Value("#{application['zhst.loan.payurl']?:''}")
	@EntityFieldAttribute(name="贷款信审支付地址",desc="贷款信审支付地址",type="String")
	private String loanPayUrl;

	/**
	 * 贷款信审支付成功回调地址
	 */
	@Value("#{application['zhst.loan.paySuccessUrl']?:''}")
	@EntityFieldAttribute(name="支付成功回调地址",desc="支付成功回调地址",type="String")
	private String paySuccessUrl;

	/**
	 * 同盾强授权地址
	 */
	@Value("#{application['zhst.authoraizationUrl']?:''}")
	@EntityFieldAttribute(name="同盾强授权地址",desc="同盾强授权地址",type="String")
	private String authoraizationUrl;

	/**
	 * 商户客户支付地址
	 */
	@Value("#{application['zhst.cust.payurl']?:'http://localhost:8090/zhst-web/zhst-pay/pay.html'}")
	@EntityFieldAttribute(name="商户客户支付地址",desc="商户客户支付地址",type="String")
	private String custPayUrl;

	/**
	 * 校验密码次数
	 */
	@Value("#{application['zhst.bcpUserCheckTradePwdTimes']?:3}")
	@EntityFieldAttribute(name="bcp校验密码次数",desc="bcp校验密码次数",type="Integer")
	private Integer bcpUserCheckTradePwdTimes;

	/**
	 * 免添正分查询报告支付费用开关 开启代表免支付
	 */
	@Value("#{application['zhst.tzfQueryFreeFlag']?:false}")
	@EntityFieldAttribute(name="免添正分查询报告支付费用开关 开启代表免支付",desc="true或false",type="Boolean")
	private Boolean tzfQueryFreeFlag;

	/**
	 * 免添正分查询报告支付费用开始时间 yyyy-MM-dd HH:mm:ss
	 */
	@Value("#{application['zhst.tzfQueryFreeBeginTime']?:''}")
	@EntityFieldAttribute(name="免添正分查询报告支付费用开始时间",desc="格式yyyy-MM-dd HH:mm:ss",type="String")
	private String tzfQueryFreeBeginTime;

	/**
	 * 免添正分查询报告支付费用结束时间 yyyy-MM-dd HH:mm:ss
	 */
	@Value("#{application['zhst.tzfQueryFreeEndTime']?:''}")
	@EntityFieldAttribute(name="免添正分查询报告支付费用结束时间",desc="格式yyyy-MM-dd HH:mm:ss",type="String")
	private String tzfQueryFreeEndTime;

	/**
	 * 免添正分查询报告支付费用活动描述
	 */
	@Value("#{application['zhst.tzfQueryFreeDesc']?:''}")
	@EntityFieldAttribute(name="免添正分查询报告支付费用活动描述",desc="免添正分查询报告支付费用活动描述",type="String")
	private String tzfQueryFreeDesc;

	/**
	 * 信审过期天数
	 */
	@Value("#{application['zhst.pretrialExpireDays']?:90}")
	@EntityFieldAttribute(name="信审过期天数",desc="信审过期天数",type="Integer")
	private Integer pretrialExpireDays;

	/**
	 * 联系平台电话
	 */
	@Value("#{application['zhst.contactNumber']?:''}")
	@EntityFieldAttribute(name="联系平台电话",desc="联系平台电话",type="String")
	private String contactNumber;

	/**
	 * 开启区块链标志
	 */
	@Value("#{application['zhst.bcpFlag']?:false}")
	@EntityFieldAttribute(name="开启区块链标志",desc="true或false",type="Boolean")
	private Boolean bcpFlag;

	/**
	 * 区块链增加减少-默认调用生效
	 */
	@Value("#{application['zhst.bcpDefaultWithMine']?:true}")
	@EntityFieldAttribute(name="区块链增加减少-默认调用生效",desc="true或false",type="Boolean")
	private Boolean bcpDefaultWithMine;
	
	/**
	 * 总体并发数预警阈值
	 */
	@Value("#{application['promo.service.maxWaitingQueueSize']?:1000}")
	@EntityFieldAttribute(name="总体并发数预警阈值",desc="总体并发数预警阈值",type="int")
	private int maxWaitingQueueSize;
	
	/**
	 * 当前系统并发达到X%的总并发数
	 */
	@Value("#{application['promo.service.alertWaitingQueueSize']?:80}")
	@EntityFieldAttribute(name="当前系统并发达到X%的总并发数",desc="当前系统并发达到X%的总并发数",type="int")
	private int alertWaitingQueueSize;

	/**
	 * 商户app资讯详情跳转www的地址
	 */
	@Value("#{application['zhst.newsListWebUrl']?:''}")
	@EntityFieldAttribute(name="商户app资讯详情跳转www的地址",desc="商户app资讯详情跳转www的地址",type="String")
	private String newsListWebUrl;
	
	/**
	 * 贷款授权过期天数
	 */
	@Value("#{application['zhst.authorizationExpireDays']?:30}")
	@EntityFieldAttribute(name="贷款授权过期天数",desc="贷款授权过期天数",type="String")
	private Integer authorizationExpireDays;

	/**
	 * 每日定时统计收银数据的时间
	 */
	@Value("#{application['zhst.cashDataStatisticsTime']?:'03:00:00'}")
	@EntityFieldAttribute(name="定时统计收银数据的时间",desc="定时统计收银数据的时间(HH:mm:ss)",type="String")
	private String cashDataStatisticsTime;

	/**
	 * 贷款信审支付金额(元)
	 */
	@Value("#{application['zhst.loan.paymoney']?:'100'}")
	@EntityFieldAttribute(name="贷款信审支付金额",desc="贷款信审支付金额",type="String")
	private String loanPayMoney;

	@Value("#{application['zhst.creditPassMessage']?:'您的贷款申请添正分查询已通过，工作人员会尽快与您联系。请保持注册手机畅通！'}")
	@EntityFieldAttribute(name="信审通过推送消息",desc="信审通过推送消息",type="String")
	private String creditPassMessage;

	@Value("#{application['zhst.creditNotPassMessage']?:'您的贷款申请添正分查询不通过！'}")
	@EntityFieldAttribute(name="信审不通过推送消息",desc="信审不通过推送消息",type="String")
	private String creditNotPassMessage;

	/**
	 * APP上传图片最大尺寸
	 */
	@Value("#{application['zhst.appUploadImgMaxSize']?:'300'}")
	@EntityFieldAttribute(name = "APP上传图片最大尺寸", desc = "APP上传图片最大尺寸", type = "String")
	private String appUploadImgMaxSize;

	/**
	 * 每日定时上传商铺门店数据的时间
	 */
	@Value("#{application['zhst.shopDataUploadTime']?:'04:00:00'}")
	@EntityFieldAttribute(name = "定时上传商铺门店数据的时间", desc = "定时上传商铺门店数据的时间(HH:mm:ss)", type = "String")
	private String shopDataUploadTime;

	/**
	 * @return the homeBannerCatalogName
	 */
	public String getHomeBannerCatalogName() {
		return homeBannerCatalogName;
	}

	/**
	 * @return the infoBannerCatalogName
	 */
	public String getInfoBannerCatalogName() {
		return infoBannerCatalogName;
	}

	/**
	 * @return the infoListCatalogName
	 */
	public String getInfoListCatalogName() {
		return infoListCatalogName;
	}

	/**
	 * @return the zhstWebAppIp
	 */
	public String getZhstWebAppIp() {
		return zhstWebAppIp;
	}

	public String getPushMessageClientApp() {
		return pushMessageClientApp;
	}

	public String getPushMessageTopic() {
		return pushMessageTopic;
	}

	public String getPushMessageVersion() {
		return pushMessageVersion;
	}

	public String getPushMessagEencrypt() {
		return pushMessagEencrypt;
	}

	public String getPushMessagePwd() {
		return pushMessagePwd;
	}

	public String getPushMessageFilename() {
		return pushMessageFilename;
	}

	public String getPushMessagePublicFilename() {
		return pushMessagePublicFilename;
	}

	public String getPushMessagepushHost() {
		return pushMessagepushHost;
	}

	public String getPortHostName() {
		return portHostName;
	}

	public String getPhoneHostName() {
		return phoneHostName;
	}

	public String getAppHostName() {
		return appHostName;
	}

	public String getEtradeHostName() {
		return etradeHostName;
	}

	public String getWgHostName() {
		return wgHostName;
	}

	public String getWxHostName() {
		return wxHostName;
	}

	public String getPortSkin() {
		return portSkin;
	}

	public String getPhoneSkin() {
		return phoneSkin;
	}

	public String getAppSkin() {
		return appSkin;
	}

	public String getEtradeSkin() {
		return etradeSkin;
	}

	public String getWgSkin() {
		return wgSkin;
	}

	public String getWxSkin() {
		return wxSkin;
	}

	public String getSiteTypeFlag() {
		return siteTypeFlag;
	}

	/**
	 * @return the checkIdAndTime
	 */
	public boolean isCheckIdAndTime() {
		return checkIdAndTime;
	}

	/**
	 * @return the checkTimestampDiff
	 */
	public int getCheckTimestampDiff() {
		return checkTimestampDiff;
	}

	/**
	 * @return the serverUrlPrefix
	 */
	public String getServerUrlPrefix() {
		return serverUrlPrefix;
	}

	/**
	 * @return the phoneClientConfigFile
	 */
	public String getPhoneClientConfigFile() {
		return phoneClientConfigFile;
	}

	/**
	 * @return the versionServiceUrl
	 */
	public String getVersionServiceUrl() {
		return versionServiceUrl;
	}

	/**
	 * @return the funcServiceUrl
	 */
	public String getFuncServiceUrl() {
		return funcServiceUrl;
	}

	/**
	 * @return the useRealMsg
	 */
	public String getUseRealMsg() {
		return useRealMsg;
	}

	/**
	 * @return the smsCodeCountLimit
	 */
	public Integer getSmsCodeCountLimit() {
		return smsCodeCountLimit;
	}

	/**
	 * @return the staticZipSourcesDir
	 */
	public String getStaticZipSourcesDir() {
		return staticZipSourcesDir;
	}

	/**
	 * @return the generateImgValidCodeDynamic
	 */
	public String getGenerateImgValidCodeDynamic() {
		return generateImgValidCodeDynamic;
	}

	/**
	 * @return the questionnaireId
	 */
	public String getQuestionnaireId() {
		return questionnaireId;
	}

	/**
	 * @return the incomeWithDrawTaxRate
	 */
	public Double getIncomeWithDrawTaxRate() {
		return incomeWithDrawTaxRate;
	}

	/**
	 * @return the chinaAreaId
	 */
	public String getChinaAreaCode() {
		return chinaAreaCode;
	}

	/**
	 * @return the sendRepaymentDayNum
	 */
	public Integer getSendRepaymentDayNum() {
		return sendRepaymentDayNum;
	}

	/**
	 * @return the smsChoose
	 */
	public String getSmsChoose() {
		return smsChoose;
	}

	/**
	 * @return the smsValidateTemplateid
	 */
	public String getSmsValidateTemplateid() {
		return smsValidateTemplateid;
	}

	/**
	 * @return the smsNoticeTemplateid
	 */
	public String getSmsNoticeTemplateid() {
		return smsNoticeTemplateid;
	}

	/**
	 * @return the borrowerIncomeWithDrawTaxRate
	 */
	public Double getBorrowerIncomeWithDrawTaxRate() {
		return borrowerIncomeWithDrawTaxRate;
	}

	/**
	 * @return the loanPayUrl
	 */
	public String getLoanPayUrl() {
		return loanPayUrl;
	}

	public Integer getImgValidCodeValidationTimes() {
		return imgValidCodeValidationTimes;
	}

	/**
	 * @return the custPayUrl
	 */
	public String getCustPayUrl() {
		return custPayUrl;
	}

	/**
	 * @return the bcpUserCheckTradePwdTimes
	 */
	public Integer getBcpUserCheckTradePwdTimes() {
		return bcpUserCheckTradePwdTimes;
	}

	/**
	 * @return the tzfQueryFreeFlag
	 */
	public Boolean getTzfQueryFreeFlag() {
		return tzfQueryFreeFlag;
	}

	/**
	 * @return the tzfQueryFreeBeginTime
	 */
	public String getTzfQueryFreeBeginTime() {
		return tzfQueryFreeBeginTime;
	}

	/**
	 * @return the tzfQueryFreeEndTime
	 */
	public String getTzfQueryFreeEndTime() {
		return tzfQueryFreeEndTime;
	}

	/**
	 * @return the tzfQueryFreeDesc
	 */
	public String getTzfQueryFreeDesc() {
		return tzfQueryFreeDesc;
	}

	/**
	 * @return the pretrialExpireDays
	 */
	public Integer getPretrialExpireDays() {
		return pretrialExpireDays;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @return the authoraizationUrl
	 */
	public String getAuthoraizationUrl() {
		return authoraizationUrl;
	}

	/**
	 * @return the bcpFlag
	 */
	public Boolean getBcpFlag() {
		return bcpFlag;
	}

	/**
	 * @return the maxWaitingQueueSize
	 */
	public int getMaxWaitingQueueSize() {
		return maxWaitingQueueSize;
	}

	/**
	 * @return the alertWaitingQueueSize
	 */
	public int getAlertWaitingQueueSize() {
		return alertWaitingQueueSize;
	}

	public Boolean getBcpDefaultWithMine() {
		return bcpDefaultWithMine;
	}

	public String getNewsListWebUrl() {
		return newsListWebUrl;
	}

	public Integer getAuthorizationExpireDays() {
		return authorizationExpireDays;
	}

	public String getCashDataStatisticsTime() {
		return cashDataStatisticsTime;
	}
	/**
	 * @return the loanPayMoney
	 */
	public String getLoanPayMoney() {
		return loanPayMoney;
	}

	/**
	 * @return the paySuccessUrl
	 */
	public String getPaySuccessUrl() {
		return paySuccessUrl;
	}

	public String getCreditPassMessage() {
		return creditPassMessage;
	}

	public String getCreditNotPassMessage() {
		return creditNotPassMessage;
	}

	/**
	 * @return the appUploadImgMaxSize
	 */
	public String getAppUploadImgMaxSize() {
		return appUploadImgMaxSize;
	}

	/**
	 * @return the shopDataUploadTime
	 */
	public String getShopDataUploadTime() {
		return shopDataUploadTime;
	}

}
