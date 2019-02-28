package cn.ly.mlc.mg.action.home;

import cn.ly.mlc.mg.action.base.BaseAction;
import cn.ly.mlc.mg.entity.PrivilegeConfig;
import cn.ly.mlc.mg.entity.request.BaseRequest;
import com.mysql.jdbc.StringUtils;
import common.privilege.PrivilegeOperate;
import common.web.annotation.TopdeepMethodAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import topdeep.cms.entity.db.CmsAdminToSite;
import topdeep.cms.entity.db.CmsAdminToSiteKey;
import topdeep.cms.entity.db.CmsSiteInfo;
import topdeep.cms.entity.db.CmsSiteInfoExample;
import topdeep.cms.mg.biz.common.CmsMgSystemBiz;
import topdeep.cms.mg.entity.CmsPrivilegeConfig;
import topdeep.common.entity.constant.BaseInfoType;
import topdeep.common.entity.constant.EnumType.SystemType;
import topdeep.common.entity.constant.NameValue;
import topdeep.common.entity.db.SystemBaseInfo;
import topdeep.common.entity.db.SystemBaseInfoExample;
import topdeep.common.mg.entity.request.NavRequest;
import topdeep.common.mg.entity.response.NavResponse;
import topdeep.common.mg.entity.system.SystemMenu;
import cn.ly.mlc.mg.action.base.BaseAction;
import cn.ly.mlc.mg.entity.PrivilegeConfig;
import cn.ly.mlc.mg.entity.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = { "/h", "/home" })
public class NavAction extends BaseAction {

	private static final List<SystemMenu> MENU_LIST = new ArrayList<SystemMenu>();

	@Autowired
	@Qualifier("cmsMgSystemBiz")
	private CmsMgSystemBiz cmsMgSystemBiz;

	static {
		SystemMenu parentMenu;
		SystemMenu menu;
		int parentMenuIdSn = 1000;
		int k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "系统管理", 0, PrivilegeConfig.FUNC_NOT_NEED,
				PrivilegeOperate.Read, "fa fa-cog fa-fw");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/system/adminManage.action", "员工管理",
				1, PrivilegeConfig.FUNC_OPERATOR_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/system/rolesManage.action", "角色管理",
				1, PrivilegeConfig.FUNC_ROLE_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/system/refreshCacheManage.action",
				"刷新缓存", 1, PrivilegeConfig.FUNC_REFRESH_CACHE_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/system/templateManage.action?templateType=0&templateCatalog=shortMsg",
				"短信模板", 1,
				PrivilegeConfig.FUNC_MSG_TEMPLATE_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/common/workDayManage.action","工作日管理", 1,
				PrivilegeConfig.FUNC_WORKDAY_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/common/commonAreaManage.action","行政区维护", 1,
				PrivilegeConfig.FUNC_COMMON_AREA_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "参数配置", 0, PrivilegeConfig.FUNC_NOT_NEED,
				PrivilegeOperate.Read, "fa  fa-database");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/system/systemConfigManage.action", "参数设置", 1,
				PrivilegeConfig.FUNC_SYSTEM_CONFIG_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "数据字典", 0, PrivilegeConfig.FUNC_NOT_NEED,
				PrivilegeOperate.Read, "fa  fa-book");
		MENU_LIST.add(parentMenu);


		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "客户端管理", 0, PrivilegeConfig.FUNC_NOT_NEED,
				PrivilegeOperate.Read, "fa fa-wrench");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/client/clientVersionManage.action",
				"客户端版本", 1, PrivilegeConfig.FUNC_CLIENT_VERSION_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(),
				"/client/clientActivationManage.action", "客户端激活量数据分析", 1, PrivilegeConfig.FUNC_CLIENT_ACTIVATION_MANAGE,
				PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "资讯管理", 0, PrivilegeConfig.FUNC_NOT_NEED,
				PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);

		// menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/news/newsManage.action", "资讯编辑", 1,
		// CmsPrivilegeConfig.FUNC_NEWS_MANAGE, PrivilegeOperate.Read, "");
		// parentMenu.addChildMenu(menu);
		// menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/news/newsCatalogManage.action", "资讯分类", 1,
		// CmsPrivilegeConfig.FUNC_NEWS_CATALOG_MANAGE, PrivilegeOperate.Read, "");
		// parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/news/newsArticle.action", "资讯文章", 1,
				CmsPrivilegeConfig.FUNC_NEWS_ARTICLE_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/news/resourceManage.action", "资源管理",
				1, CmsPrivilegeConfig.FUNC_RESOURCES_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		// 问卷系统
		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "问卷系统", 0, CmsPrivilegeConfig.FUNC_NOT_NEED, PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/question/questionCatalogManage.action", "题库管理", 1,
				CmsPrivilegeConfig.FUNC_QUESTION_CATALOG_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/question/questionManage.action", "题目管理", 1,
				CmsPrivilegeConfig.FUNC_QUESTION_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/question/questionnaireManage.action", "问卷管理", 1,
				CmsPrivilegeConfig.FUNC_QUESTIONNAIRE_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "通知公告", 0, PrivilegeConfig.FUNC_NOT_NEED, PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/system/noticeManage.action", "通知公告管理", 1,
				PrivilegeConfig.FUNC_NOTICE_ANNOUNCEMENT_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "贷款管理", 0, PrivilegeConfig.FUNC_NOT_NEED, PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);

		// menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/news/newsManage.action", "资讯编辑", 1,
		// CmsPrivilegeConfig.FUNC_NEWS_MANAGE, PrivilegeOperate.Read, "");
		// parentMenu.addChildMenu(menu);
		// menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/news/newsCatalogManage.action", "资讯分类", 1,
		// CmsPrivilegeConfig.FUNC_NEWS_CATALOG_MANAGE, PrivilegeOperate.Read, "");
		// parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/loan/industryCategory.action", "商铺行业", 1,
				PrivilegeConfig.FUNC_INDUSTRY_CATEGORY_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/loan/creditManage.action", "信审人工审核", 1,
				PrivilegeConfig.FUNC_CREDIT_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/loan/firstTrialManage.action", "初审放款额度确认", 1,
				PrivilegeConfig.FUNC_FIRSTTRIAL_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/loan/confirmValueManage.action", "初审放款额度修改确认", 1,
				PrivilegeConfig.FUNC_CONFIRM_VALUE_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/loan/waitMakeMoneyManage.action", "打款管理", 1,
				PrivilegeConfig.FUNC_MAKE_MONEY_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/loan/loanInfoManage.action", "贷款信息查询", 1,
				PrivilegeConfig.FUNC_LOAN_INFO_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		
		//到店尽调
		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "到店尽调", 0, PrivilegeConfig.FUNC_NOT_NEED, PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/investigate/investigateShopManage.action", "商铺门店", 1,
				PrivilegeConfig.FUNC_INVESTIGATE_SHOP_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/investigate/investigateTaskManage.action", "尽调派单", 1,
				PrivilegeConfig.FUNC_INVESTIGATE_TASK_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/investigate/investigateAuditManage.action", "尽调审核", 1,
				PrivilegeConfig.FUNC_INVESTIGATE_AUDIT_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/investigate/investigateDeviceManage.action", "门店设备", 1,
				PrivilegeConfig.FUNC_INVESTIGATE_DEVICE_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		
		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "商铺管理", 0, PrivilegeConfig.FUNC_NOT_NEED, PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/store/storeQRCodeManage.action", "商铺管理", 1,
				PrivilegeConfig.FUNC_STORE_QR_CODE_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/store/cashDataManage.action", "收银数据管理", 1,
				PrivilegeConfig.FUNC_CASH_DATA_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		// 基础信息
		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "基础信息", 0, PrivilegeConfig.FUNC_NOT_NEED, PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/common/bankInfoManage.action", "银行信息维护", 1,
				PrivilegeConfig.FUNC_BANK_INFO_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		// 积分活动
		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "积分活动", 0, PrivilegeConfig.FUNC_NOT_NEED, PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/point/pointSystemManage.action", "积分活动信息维护", 1,
				PrivilegeConfig.POINT_SYSTEM_INFO_MANAGE, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);

		// 积分活动
		k = 1;
		parentMenu = new SystemMenu(parentMenuIdSn++, 0, "", "区块链应用", 0, PrivilegeConfig.FUNC_NOT_NEED, PrivilegeOperate.Read, "fa fa-dashboard fa-fw");
		MENU_LIST.add(parentMenu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/bcp/borrowerIncomeQuery.action", "商户积分查询", 1,
				PrivilegeConfig.BORROWER_INCOME_QUERY, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/bcp/borrowerIncomeClear.action", "商户积分清零", 1,
				PrivilegeConfig.BORROWER_INCOME_CLEAR, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/bcp/pointUserInfoQuery.action", "客户信息查询", 1,
				PrivilegeConfig.POINT_USER_INFO_QUERY, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/bcp/pointUserIncomeQuery.action", "客户积分查询", 1,
				PrivilegeConfig.POINT_USER_INCOME_QUERY, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);
		menu = new SystemMenu(parentMenu.getId() * 10 + k++, parentMenu.getId(), "/bcp/pointUserIncomeExtractMonthBill.action", "客户积分提现月账单", 1,
				PrivilegeConfig.POINT_USER_INCOME_EXTRACT_MONTH_BILL, PrivilegeOperate.Read, "");
		parentMenu.addChildMenu(menu);



	}

	@TopdeepMethodAttribute(loginRequired = false)
	@RequestMapping(value = "/nav!ajaxSwitchMenu", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public NavResponse ajaxSwitchMenu(NavRequest req) {
		NavResponse res = new NavResponse();
		super.execute(req, res, true, true);
		if (res.isSuccess() && webUserRuntimeBiz.isLogin()) {
			webUserRuntimeBiz.setSelectedSiteId(req.getSwitchTo());
			try {
				CmsAdminToSite obj = cmsMgSystemBiz.cmsAdminToSiteSelectByPrimaryKey(
						new CmsAdminToSiteKey(webUserRuntimeBiz.getLoginUserId(), req.getSwitchTo()));
				if (obj != null) {
					obj.setIsDefault("1");
					cmsMgSystemBiz.cmsAdminToSiteUpdate(obj);
				}
			} catch (Exception ex) {
				logger.error("ajaxSwitchMenu error: " + ex.getMessage(), ex);
			}
		}
		return res;
	}

	@TopdeepMethodAttribute(loginRequired = false, isAjaxMethod = true)
	@RequestMapping(value = "/nav!ajaxQueryMenus", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public NavResponse ajaxQueryMenus(BaseRequest req) {
		NavResponse res = new NavResponse();
		super.execute(req, res, true, true);
		if (res.isSuccess()) {
			res.setMenuList(getLoginUserMenus());
			res.setRightMenuList(getRightMenus());
			res.setSwitchMenuList(getSwitchMenus());
		}
		return res;
	}

	public List<SystemMenu> getLoginUserMenus() {
		List<SystemMenu> menus = new ArrayList<SystemMenu>();
		try {
			for (SystemMenu item : MENU_LIST) {
				SystemMenu newItem = new SystemMenu(item.getId(), item.getParentId(), item.getUrl(), item.getName(),
						item.getLevel(), item.getIconClass());
				menus.add(newItem);
				for (SystemMenu item1 : item.getChildList()) {
					newItem.getChildList().add(item1);
				}
				if (newItem.getName().equals("数据字典")) {
					SystemBaseInfoExample condition = new SystemBaseInfoExample();
					condition.or().andSystemTypeEqualTo(SystemType.Common.getValue())
							.andCodeTypeEqualTo(BaseInfoType.USER_BASE_INFO_TYPE_LIST);
					condition.setOrderByClause("ORDER_FIELD asc");
					List<SystemBaseInfo> baseInfoList = commonSystemBiz.systemBaseInfoSelectObjects(condition);
					int k = 1;
					for (int i = 0; i < baseInfoList.size(); i++) {
						SystemBaseInfo baseInfo = baseInfoList.get(i);
						boolean hasPrivilege = false;
						if (!StringUtils.isNullOrEmpty(baseInfo.getCodeDesc())) {
							int priValue = Integer.parseInt(baseInfo.getCodeDesc());
							if (webUserRuntimeBiz.hasPrivilege(priValue, PrivilegeOperate.Execute)) {
								hasPrivilege = true;
							}
						} else {
							hasPrivilege = true;
						}
						if (hasPrivilege) {
							SystemMenu menu = new SystemMenu(newItem.getId() * 100 + k, newItem.getId(),
									"/system/baseInfoManage.action?codeType=" + baseInfo.getCodeId(),
									baseInfo.getCodeName(), 1, PrivilegeConfig.FUNC_BASE_INFO_MANGE,
									PrivilegeOperate.Read, "");
							newItem.getChildList().add(menu);
							k++;
						}
					}

				}

			}
			for (int i = menus.size() - 1; i >= 0; i--) {
				SystemMenu parentMenu = menus.get(i);
				if (parentMenu.getChildList().size() > 0) {
					for (int j = parentMenu.getChildList().size() - 1; j >= 0; j--) {
						SystemMenu childMenu = parentMenu.getChildList().get(j);
						if (!webUserRuntimeBiz.hasPrivilege(childMenu.getPrivilegeFunc(),
								childMenu.getPrivilegeOperate())) {
							parentMenu.getChildList().remove(j);
						}
					}
					if (parentMenu.getChildList().size() == 0) {
						menus.remove(i);
					}
				} else {
					if (!webUserRuntimeBiz.hasPrivilege(parentMenu.getPrivilegeFunc(),
							parentMenu.getPrivilegeOperate())) {
						menus.remove(i);
					}
				}
			}
		} catch (Exception e) {
			logger.error("getLoginUserMenus error: " + e.getMessage(), e);
		}
		return menus;
	}

	public List<NameValue> getRightMenus() {
		List<NameValue> list = new ArrayList<NameValue>();
		NameValue nv = null;
		nv = new NameValue("修改密码", "/h/changePwd.action");
		list.add(nv);
		nv = new NameValue("退出", "/h/logout.action");
		list.add(nv);
		return list;
	}

	public List<NameValue> getSwitchMenus() {
		List<NameValue> list = new ArrayList<NameValue>();
		try {
			if (webUserRuntimeBiz != null && webUserRuntimeBiz.isLogin()
					&& !StringUtils.isNullOrEmpty(webUserRuntimeBiz.getLoginSuperUserId())) {
				CmsSiteInfoExample condition = new CmsSiteInfoExample();
				condition.or().andAdminIdEqualTo(webUserRuntimeBiz.getLoginSuperUserId()).andDeletedEqualTo("0");
				condition.setOrderByClause("SITE_NAME asc");
				List<CmsSiteInfo> projectList = cmsMgSystemBiz.cmsSiteInfoSelectObjects(condition);
				for (CmsSiteInfo item : projectList) {
					if (item.getId().equals(webUserRuntimeBiz.getSelectedSiteId())) {
						NameValue nv = new NameValue(item.getSiteName(),
								"/h/nav!ajaxSwitchMenu.action?switchTo=" + item.getId());
						list.add(nv);
						break;
					}
				}
				for (CmsSiteInfo item : projectList) {
					if (!item.getId().equals(webUserRuntimeBiz.getSelectedSiteId())) {
						NameValue nv = new NameValue(item.getSiteName(),
								"/h/nav!ajaxSwitchMenu.action?switchTo=" + item.getId());
						list.add(nv);
					}
				}
				// list.add(new NameValue("-", "#"));
				// list.add(new NameValue("创建新站点", "/h/siteProfile!ajaxRegistNew.action"));

			}
		} catch (Exception ex) {
			logger.error("getSwitchMenus error: " + ex.getMessage(), ex);
		}
		return list;
	}

}
