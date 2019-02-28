package cn.ly.mlc.entity.constant;

/**
 * 
 * @author shidewen
 *
 */
public class EnumType {

	public enum SiteType{
		WWW("门户网站","0"),
		M("手机网站","1"),
		App("客户端","2"),
		ETRADE("交易网站","3"),
		WG("微信网关","4"),
		WX("微信网站","5");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private SiteType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum ClientType{
		HTML("H5静态页","html"),
		IOS("苹果客户端","ios"),
		ANDROID("安卓客户端","android");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private ClientType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum ClientVersionState{
		ISNEW("版本最新","0"),
		ALLOWRUN("非最新版本但是运行允许","1"),
		NEEDUPDATE("需要强制更新","2");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private ClientVersionState(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum ValidInfoCannelType{
		MOBILEMSG("手机短信","1"),
		EMAIL("邮件","2");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private ValidInfoCannelType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum ClientBindState{
		UNBIND("未绑定","0"),
		BIND("已绑定","1");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private ClientBindState(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum LoginType{
		MOBILE("手机","1");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private LoginType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum ThumbnailFlag{
		YES("是","1"),
		NO("否","2");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private ThumbnailFlag(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum RegisterIdType{
		MOBILE("手机","1");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private RegisterIdType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum ClientFuncType{
		GETCLIENTVERSION("获取客户端版本信息","getClientVersion"),
		TOPDEEPLOG("日志打印","topdeepLog"),
		FILEUPLOAD("文件上传","fileUpload");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private ClientFuncType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}
	
	public enum LoanState {
		NOTCOMMIT("待提交", "0"),
		PRETRIALING("信审中", "1"),
		PRETRIALPASS("信审通过", "2"),
		PRETRIALFAIL("信审不通过", "3"),
		NOFIRSTTRIAL("待初审", "4"),
		FIRSTTRIALPASS("初审通过", "5"),
		FIRSTTRIALFAIL("初审不通过", "6"),
		NOTFINALADJUDICATION("待终审", "7"),
		FINALADJUDICATIONING("终审中", "8"),
		FINALADJUDICATIONPASS("终审通过", "9"),
		COMPLETE("已结清", "a"),
		FIRSTTRIALING("初审中", "b");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private LoanState(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public enum BusinessType{
		LOAN("贷款","01"),
		DRAW("放款","02"),
		ORDER("订单", "03"),
		MAKEMONEY("打款", "04");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private BusinessType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}

	public enum InvestgateFileType {
		DOOR_PLATE_PIC("门牌图片", "doorPlate"),
		LOBBY_PIC("大堂图片", "lobby"),
		CASH_REGISTER_PIC("收银机图片", "cashRegister"),
		HW_SETUP_PIC("硬件安装图片", "hardWare"),
		POS_DATA("POS机交易流水数据", "posData"),
		ALIPAY_DATA("支付宝交易流水数据", "alipayData"),
		WECHATPAY_DATA("微信支付交易流水数据", "wechatPayData"),
		SHOPHOUSEORRENTALAGREEMENT("门店房产证或房屋租赁合同照片", "houseOrRentalagreement"),
		OTHERFILES("其他文件","otherFiles");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private InvestgateFileType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum ImgRelativeType{
		BORROWERIMG1("借款人身份证正面照","1"),
		BORROWERIMG2("借款人身份证反面照","2"),
		BUSINESSIMG("营业执照","3"),
		CORPORATIONIMG1("法人身份证正面照","4"),
		CORPORATIONIMG2("法人身份证反面照","5"),
		STORESHOUSEPROVEIMG("房产证或房屋租赁合同照片", "6"),
		DOOR_PLATE_PIC("门牌图片", "7"),
		DOOR_PLATE_PIC2("门牌图片2", "8"),
		DOOR_PLATE_PIC3("门牌图片3", "9"),
		DOOR_PLATE_PIC4("门牌图片4", "10"),
		LOBBY_PIC("大堂图片", "11"),
		LOBBY_PIC2("大堂图片2", "12"),
		LOBBY_PIC3("大堂图片3", "13"),
		LOBBY_PIC4("大堂图片4", "14"),
		CASH_REGISTER_PIC("收银机图片", "15"),
		CASH_REGISTER_PIC2("收银机图片2", "16"),
		CASH_REGISTER_PIC3("收银机图片3", "17"),
		CASH_REGISTER_PIC4("收银机图片4", "18"),
		HW_SETUP_PIC("硬件安装图片", "19"),
		HW_SETUP_PIC2("硬件安装图片2", "20"),
		HW_SETUP_PIC3("硬件安装图片3", "21"),
		HW_SETUP_PIC4("硬件安装图片4", "22"),
		POS_DATA("POS机交易流水数据", "23"),
		ALIPAY_DATA("支付宝交易流水数据", "24"),
		WECHATPAY_DATA("微信支付交易流水数据", "25"),
		SHOPHOUSEORRENTALAGREEMENT("门店房产证或房屋租赁合同照片", "26"),
		OTHERFILES("其他文件", "27"),
		STORESHOUSEPROVEIMG2("房产证或房屋租赁合同照片2", "28"),
		STORESHOUSEPROVEIMG3("房产证或房屋租赁合同照片3", "29"),
		STORESHOUSEPROVEIMG4("房产证或房屋租赁合同照片4", "30");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private ImgRelativeType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}

	public enum InvestigatorStatus {
		NOTORDER("未接单", "0"),
		NOTARRIVAL("已接单未到店", "1"),
		INVESTIGATORING("到店尽调中", "2"),
		COMPLETE("已结束尽调", "3");

		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private InvestigatorStatus(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public enum DrawState{
		APPLY("已申请","1"),
		AUDITING("处理中","2"),
		SUCCESS("打款成功","3"),
		FAIL("打款失败","4");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private DrawState(String name, String value){
			this.name = name;
			this.value = value;
		}
	}

	public enum CreditAuditType {
		SYSTEMAUDIT("系统审核", "1"),
		MANUALAUDIT("人工审核", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private CreditAuditType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum CreditAuditFailType {
		INFOINCOMPLETE("资料审核不通过", "1"),
		CREDITFAIL("信审不通过", "2"),
		OTHERREASON("其他原因", "3");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private CreditAuditFailType(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public static String getNameByValue(String value) {
			for (CreditAuditFailType s : CreditAuditFailType.values()) {
				if (value.equals(s.getValue())) {
					return s.getName();
				}
			}
			return null;
		}
	}
	
	public enum RepayMentState{
		WAITPAY("待还","1"),
		NORMAL("正常","2"),
		TIMEOUT("逾期","3");
		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private RepayMentState(String name, String value){
			this.name = name;
			this.value = value;
		}
	}

	public enum TrustTrialState {
		PRETRIALPASS("信审通过", "0"),
		PRETRIALFAIL("信审不通过", "1"),
		PRETRIALING("待确认", "2"),
		;
		
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}
		private TrustTrialState(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public static String getNameByValue(String value) {
			for (TrustTrialState state : TrustTrialState.values()) {
				if (value.equals(state.getValue())) {
					return state.getName();
				}
			}
			return null;
		}
	}
	public enum UserType {
		BORROWER("借款人", "1"),
		PLATUSER("平台员工", "5"),
		BCPUSER("积分用户", "6");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}
		private UserType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum BCPUserType {
		CCLIENTUSER("C端客户", "0"),
		BCLIENTUSER("B端借款人", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private BCPUserType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum PayNoticeLoanState {
		NOTNOTICELOAN("未通知小贷打款", "0"),
		NOTICELOAN("已通知小贷打款", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}
		private PayNoticeLoanState(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
		
		
	public enum ApplyStatus {
		APPLYING("申请中", "0"),
		PASS("已通过", "1"),
		REFUSE("已拒绝", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private ApplyStatus(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum MakeMoneyState {
		MAKEMONEYPASS("小贷打款完成", "0"),
		MAKEMONEYFAIL("小贷打款失败", "1"),
		MAKEMONEY("小贷未打款", "2");
		
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private MakeMoneyState(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
		
		
	public enum TaskStatus {
		WAITING("申请中", "0"),
		ACCEPTED("已接单暂未到店", "1"),
		INVESTIGATING("到店尽调中", "2"),
		FINISH("已结束", "3");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}
		private TaskStatus(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum TimeLimitUnit {
		DAY("天", "0"),
		WEEK("周", "1"),
		MONTH("月", "2"),
		YEAR("年", "3");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private TimeLimitUnit(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	// public enum ReplayMentState {
	// REMAINRETURN("待还", "0"),
	// NORMAL("正常", "1"),
	// OVERDUE("逾期", "2");
	// private String name;
	// private String value;
	//
	// public String getName() {
	// return this.name;
	// }
	//
	// public String getValue() {
	// return this.value;
	// }
	//
	// private ReplayMentState(String name, String value) {
	// this.name = name;
	// this.value = value;
	// }
	// }

	public enum DeviceType {
		WIFIPROBE("wifi", "0");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private DeviceType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum DeviceState {
		BLOCKUP("停用", "0"),
		STARTUP("启动", "1");

		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private DeviceState(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public enum OrderState {
		ORDERCREATE("已下单", "0"),
		PAY("已支付", "1"),
		ORDERCANCLE("订单取消", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private OrderState(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public enum PayState {
		NOTPAY("未支付", "0"),
		PAYSUCCESS("支付成功", "1"),
		PAYFAIL("支付失败", "2"),
		PAYING("支付中", "3");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private PayState(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum OrderOperateType {
		PAY("订单支付", "1"),
		CREATEANDPAY("订单创建并支付", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private OrderOperateType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public enum WyhdAuthorizationSrc {
		WX("微信", "weixin"),
		ALIPAY("支付宝", "alipay"),
		WEIXINAPP("微信小程序", "weixinApp");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private WyhdAuthorizationSrc(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum YieldType {
		BANK("银行利息", "0"),
		POINTSYSTEM("活动计息", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private YieldType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum SecondAccountOpenFlag {
		YES("已开二类户", "0"),
		NOT("未开二类户", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private SecondAccountOpenFlag(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum RegistFlag {
		YES("已注册", "0"),
		NOT("未注册", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private RegistFlag(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum InvestmentDetailStatus {
		ARRANGE("筹备中", "0"),
		CLOSE("封闭中", "1"),
		POINT_END("活动结束", "2"),
		POINT_EARLY_TERMINATION("活动提前结束", "3"),
		USER_EARLY_TERMINATION("用户提前终止", "4");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private InvestmentDetailStatus(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum InvestAccountChangeType {
		DEPOSIT("账户存款", "0"),
		WITHDRAW("账户取款", "1"),
		INVEST_FREEZE("投资冻结", "2"),
		BANK_INTEREST("银行计息", "3"),
		WITHDRAW_INCOME("提取收益获得", "4"),
		WITHDRAW_INCOME_TAX("提取收益时扣税", "5");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private InvestAccountChangeType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum IncomeAccountChangeType {
		INVEST("积分用户投资活动获得收益", "0"),
		PROMO("积分用户到店签到活动获得收益", "1"),
		WITHDRAW_INCOME("积分用户提取收益", "2"),
		POINTFREEZE("积分用户消费冻结收益", "3"),
		POINTUNFREEZE("积分用户取消交易解冻收益", "4"),
		POINTDEDUCTION("积分用户消费成功扣除收益", "5"),
		POINTTRANSFER("商户收款获得收益", "6"),
		POINTCLEAR("商户收益清零操作", "7");

		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private IncomeAccountChangeType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum PromoAttendResult {
		SUCCESS("成功", "0"),
		FAIL("失败", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private PromoAttendResult(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum PointSystemStatus {
		NORMAL("认筹中", "0"),
		CLOSE("封闭中", "1"),
		END("已结束", "2"),
		EARLY_END("提前结束", "3");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private PointSystemStatus(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum PromoJoinFlag {
		YES("可参与", "0"),
		NOT("不可参与", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private PromoJoinFlag(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum PromoJoinResult {
		SUCCESS("成功", "0"),
		FAIL("失败", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private PromoJoinResult(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum SmsChoose {
		LoongLink("龙举短信", "1"),
		NetEase("网易短信", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private SmsChoose(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public enum BankStatus {
		NORMAL("正常", "0"),
		STOP("停用", "1");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private BankStatus(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	
	public enum ApplyTreatmentState{
		PASS("通过", "1"),
		REFUSE("拒绝", "2"),
		DELETE("删除", "3");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private ApplyTreatmentState(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum PointClearStatus {
		WAITINGTRANSFER("待打款", "0"),
		TRANSFERSUCCESS("打款成功", "1"),
		TRANSFERFAIL("打款失败", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private PointClearStatus(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public enum OrderPaySrc {
		LOANPAY("商户APP贷款支付", "1"),
		CUSTPAY("客户消费支付", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private OrderPaySrc(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public enum IntegrationPayResult {
		FREEZE("已冻结", "1"),
		SUCCESS("支付成功", "2"),
		FAIL("支付失败", "3");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private IntegrationPayResult(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum VariableClassify {
		GPSLOCATION("Gps定位", "1"),
		OPERATIONALDATA("运营数据", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private VariableClassify(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum VariableType {
		VARIABLESTRING("字符串类型", "1"),
		VARIABLENUMBER("数字", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private VariableType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum VariableDerivation {
		VARIABLESYSTEMGENERATION("系统生成", "1"),
		VARIABLECUSTOM("自定义", "2");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private VariableDerivation(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum ConditionNumberOperator {
		GREATTHAN("大于", "1"),
		LESSTHAN("小于", "2"),
		EQUALTO("等于", "3"),
		GREATTHANOREQUAL("大于等于", "4"),
		LESSTHANOREQUAL("小于等于", "5"),
		NOTEQUALTO("不等于", "6");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private ConditionNumberOperator(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum ConditionStrOperator {
		CONTAINS("包含", "7"),
		EQUALTO("等于", "8"),
		NOTCONTAINS("不包含", "9"),
		NOTEQUALTO("不等于", "10");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private ConditionStrOperator(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum ConditionParamType {
		VARIABLEPARAM("变量", "1"),
		CONSTANTPARAM("常量", "2"),
		REGEXPARAM("正则表达式", "3");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private ConditionParamType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum AuthoraizationFlag {
		YES("已强授权", "1"),
		NOT("未强授权", "0");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private AuthoraizationFlag(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum BCPAccountOpenFlag {
		YES("已开通区块链账户", "1"),
		NOT("未开通区块链账户", "0");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private BCPAccountOpenFlag(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum BlockChainRecordType {
		BORROWER_POINTS_ADD("商户增加积分", "1"),
		BORROWER_POINTS_REDUCE("商户减少积分", "2"),
		CUSTOMER_POINTS_ADD("客户增加积分", "3"),
		CUSTOMER_POINTS_REDUCE("客户减少积分", "4");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private BlockChainRecordType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}


	public enum CashRegisterType{
		LOCAL_CASHREGISTER_TYPE1("本地收银机1","1"),
		IRS_PASSIONTEC_CN_CASHREGISTER("IRSPASSIONTECCN收银机","2"),
		E_PASSIONTEC_CN_CASHREGISTER("EPASSIONTECCN收银机","3");

		private String name;
		private String value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		CashRegisterType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum CashDataStatisticsReferType{
		SHOP("门店","3"),
		STORE("商铺","2"),
		BORROWER("商户","1");

		private String name;
		private String value;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		private CashDataStatisticsReferType(String name, String value){
			this.name = name;
			this.value = value;
		}
	}


	public enum CashDataStatisticsType{
		SHOP_DAY_AMOUNT_STATISTICS("门店日营收额统计","RaOtjpcTve-1jELWuSKfw..S",0),
		SHOP_DAY_SALE_COUNTS_STATISTICS("门店日销售单数统计","zuiFPH1QziHtiqjvY75Fg..i",1),
		SHOP_DAY_ON_LAST_WEEK_DAY_AMOUNT_STATISTICS("门店当日和上周同一日营收额比较统计","TrF4rdMTXuDeOQ8k1Tnhw..z",2),
		SHOP_SD_ON_LAST_SD_AMOUNT_STATISTICS("门店近七日营收额和上个七日营收额比较统计","OJ44zYXRNWL--x-GnO-EQ..j",3),
		SHOP_SEVEN_DAYS_AMOUNT_STATISTICS("门店近七日总营收","yTccW3kRPSxE59YDS5rzw..t",4),
		SHOP_DAY_UNIT_PRICE_FOCUS_AREA_STATISTICS("门店日单价集中区域统计","gDm5JdOQVWnNLtEEN6ykA..f",5),
		SHOP_DAY_UNIT_PRICE_STATISTICS("门店日平均单价统计","dvRBagTSl2E_XPQHP57xA..l",6),
		SHOP_ON_BA_SD_CHANGE_RATE_STATISTICS("门店营收与同商圈变化率比较","KNLxtocSGaa_OPj4zJDEQ..p",7),
		SHOP_ON_CITY_INDUSTRY_CHANGE_RATE_STATISTICS("门店营收与同城行业变化率比较","b_LDJveSzirA3RB-pKccg..m",8);


		private String name;
		private String value;
		private Integer type;
		public String getName(){
			return this.name;
		}
		public String getValue(){
			return this.value;
		}
		public Integer getType() {
			return type;
		}

		private CashDataStatisticsType(String name, String value, Integer type){
			this.name = name;
			this.value = value;
			this.type = type;
		}
	}

    public enum PayChannel{
        WECHAT("微信","1"),
        ALIPAY("支付宝","2"),
        WECHAT_APP("微信小程序","3"),
		ISV_WAP("固定码","4");

        private String name;
        private String value;
        public String getName(){
            return this.name;
        }
        public String getValue(){
            return this.value;
        }
        private PayChannel(String name, String value){
            this.name = name;
            this.value = value;
        }
    }

    public enum AllowUseIntegration{
        YES("是","1"),
        NOT("否","0");

        private String name;
        private String value;
        public String getName(){
            return this.name;
        }
        public String getValue(){
            return this.value;
        }
        private AllowUseIntegration(String name, String value){
            this.name = name;
            this.value = value;
        }
    }

	public enum FileUploadStatus {
		WAITUPLOAD("待提交", "0"),
		UPLOADING("提交中", "1"),
		UPLOADSUCCEASS("提交成功", "2"),
		UPLOADFAIL("提交失败", "3");

		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private FileUploadStatus(String name, String value) {
            this.name = name;
            this.value = value;
        }
	}

	public enum ShopDataStatus {
		DATACORRECT("数据正确", "0"),
		WIFIDATAAERROR("wifi数据错误", "1"),
		TAKEAWAYDARAERROR("外卖数据错误", "2"),
		CASHDATAERROR("收银数据错误", "3");

		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private ShopDataStatus(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum RcsObjectIdType {
		IDENTITYCODE("身份证", "0"),
		BUSINESSCODE("营业执照", "y"),
		SHOPCODE("门店标识", "s");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private RcsObjectIdType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum FileDataType {
		CARRIEROPERATORDATA("运营商数据", "1"),
		CREDITTRIALDATA("信贷保镖数据", "2"),
		APPDATA("app采集信息", "3"),
		LOANAPPLYDATA("贷款申请数据", "4"),
		SHOPDATA("门店数据", "5");

		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private FileDataType(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	public enum ContactRelation {
		FATHER("父亲", "FATHER"),
		MOTHER("母亲", "MOTHER"),
		SPOUSE("配偶", "SPOUSE"),
		CHILD("子女", "CHILD"),
		OTHER_RELATIVE("其他亲属", "OTHER_RELATIVE"),
		FRIEND("朋友", "FRIEND"),
		OTHERS("其他关系", "OTHERS"),
		COWOEKER("同事", "COWORKER");
		private String name;
		private String value;

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

		private ContactRelation(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
}
