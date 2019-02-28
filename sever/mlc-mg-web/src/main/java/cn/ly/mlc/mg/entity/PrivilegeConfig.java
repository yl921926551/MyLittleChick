package cn.ly.mlc.mg.entity;

import common.privilege.PrivilegeAttribute;
import common.privilege.PrivilegeFlag;
import common.privilege.PrivilegeOperate;

@PrivilegeFlag
public class PrivilegeConfig extends topdeep.common.mg.entity.PrivilegeConfig {

	private static final int PRIVILEGE_BASE = 52000;
	//贷款管理
	@PrivilegeAttribute(Name = "信审人工审核", GroupName = "贷款管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_CREDIT_MANAGE = PRIVILEGE_BASE + 1;

	@PrivilegeAttribute(Name = "初审放款额度确认", GroupName = "贷款管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_FIRSTTRIAL_MANAGE = PRIVILEGE_BASE + 2;

	@PrivilegeAttribute(Name = "待打款管理", GroupName = "贷款管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_MAKE_MONEY_MANAGE = PRIVILEGE_BASE + 3;

	@PrivilegeAttribute(Name = "贷款信息查询", GroupName = "贷款管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_LOAN_INFO_MANAGE = PRIVILEGE_BASE + 4;

	@PrivilegeAttribute(Name = "初审放款额度修改确认", GroupName = "贷款管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_CONFIRM_VALUE_MANAGE = PRIVILEGE_BASE + 5;
	
	//到店尽调
	@PrivilegeAttribute(Name = "商铺门店", GroupName = "到店尽调", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_INVESTIGATE_SHOP_MANAGE = PRIVILEGE_BASE + 6;
	
	@PrivilegeAttribute(Name = "尽调派单", GroupName = "到店尽调", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_INVESTIGATE_TASK_MANAGE = PRIVILEGE_BASE + 7;
	
	@PrivilegeAttribute(Name = "尽调审核", GroupName = "到店尽调", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_INVESTIGATE_AUDIT_MANAGE = PRIVILEGE_BASE + 8;
	
	@PrivilegeAttribute(Name = "门店设备", GroupName = "到店尽调", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_INVESTIGATE_DEVICE_MANAGE = PRIVILEGE_BASE + 9;

	@PrivilegeAttribute(Name = "商铺管理", GroupName = "商铺管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_STORE_QR_CODE_MANAGE = PRIVILEGE_BASE + 10;

	// 基础信息
	@PrivilegeAttribute(Name = "银行信息维护", GroupName = "基础信息", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_BANK_INFO_MANAGE = PRIVILEGE_BASE + 11;

	// 积分活动
	@PrivilegeAttribute(Name = "积分活动信息维护", GroupName = "积分活动", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int POINT_SYSTEM_INFO_MANAGE = PRIVILEGE_BASE + 12;

	// 区块链
	@PrivilegeAttribute(Name = "商户积分查询", GroupName = "区块链应用", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int BORROWER_INCOME_QUERY = PRIVILEGE_BASE + 13;

	@PrivilegeAttribute(Name = "商户积分清零", GroupName = "区块链应用", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int BORROWER_INCOME_CLEAR = PRIVILEGE_BASE + 14;

	@PrivilegeAttribute(Name = "客户信息查询", GroupName = "区块链应用", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int POINT_USER_INFO_QUERY = PRIVILEGE_BASE + 15;

	@PrivilegeAttribute(Name = "客户积分查询", GroupName = "区块链应用", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int POINT_USER_INCOME_QUERY = PRIVILEGE_BASE + 16;

	@PrivilegeAttribute(Name = "客户积分提现月账单", GroupName = "区块链应用", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int POINT_USER_INCOME_EXTRACT_MONTH_BILL = PRIVILEGE_BASE + 17;

	@PrivilegeAttribute(Name = "规则变量管理", GroupName = "规则管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int RULE_VARIABLE_MANAGE = PRIVILEGE_BASE + 18;
	@PrivilegeAttribute(Name = "规则模型管理", GroupName = "规则管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int RULE_MODEL_MANAGE = PRIVILEGE_BASE + 19;
	@PrivilegeAttribute(Name = "规则策略管理", GroupName = "规则管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int RULE_STRATEGY_MANAGE = PRIVILEGE_BASE + 20;
	
	//工作日
	@PrivilegeAttribute(Name = "工作日管理", GroupName = "系统管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_WORKDAY_MANAGE = PRIVILEGE_BASE + 21;
	@PrivilegeAttribute(Name = "行政区维护", GroupName = "系统管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_COMMON_AREA_MANAGE = PRIVILEGE_BASE + 22;
	
	// 基础信息
	@PrivilegeAttribute(Name = "网关接口返回码字典管理", GroupName = "数据字典", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_GATEWAY_CODE_MANAGE = PRIVILEGE_BASE + 30;
	
	@PrivilegeAttribute(Name = "商铺行业", GroupName = "贷款管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_INDUSTRY_CATEGORY_MANAGE = PRIVILEGE_BASE + 23;

	@PrivilegeAttribute(Name = "收银数据管理", GroupName = "商铺管理", Operate = PrivilegeOperate.ReadWriteDeleteAudit)
	public static final int FUNC_CASH_DATA_MANAGE = PRIVILEGE_BASE + 24;
}
