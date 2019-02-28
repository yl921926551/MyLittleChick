/**
 * 
 */
package cn.ly.mlc.mg.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.stereotype.Service;

import topdeep.common.mg.util.ExcelUtil;
import topdeep.zhst.entity.db.ZhstPUserInfo;

import common.util.excel.ExcelUtils;
import common.util.excel.ReadObjectValue;

/**
 * @author lei.y
 *
 */
@Service("bcpExcelUtil")
public class BcpExcelUtil extends ExcelUtil {

	public InputStream getBorrowerExcelInputStream(List<ZhstPUserInfo> list, String sheetName) throws IOException, SecurityException,
			IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String[] fieldNames = {
				"商户名称", "账户可用余额(单位:分)", "账户余额(单位:分)"
		};
		String[] fields = new String[] {
				"name", "availableIncomeAmount", "totalIncomeAmount"
		};
		ExcelUtils excelUtils = new ExcelUtils();
		return excelUtils.exportToExcel(sheetName, list, fields, fieldNames, new ReadObjectValue() {
			public Object readValue(int row, int column, Object srcObj) {
				return srcObj;
			}
		});
	}

	public InputStream getBorrowerTradeDetailExcelInputStream(List<BorrowerAndUserIncomeView> list, String sheetName) throws IOException, SecurityException,
			IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String[] fieldNames = {
				"商铺主名称", "商铺子名称", "门店名称", "交易积分(单位:分)", "交易类型"
		};
		String[] fields = new String[] {
				"storeName", "storeShortName", "shopName", "changeValue", "changeTypeDesc"
		};
		ExcelUtils excelUtils = new ExcelUtils();
		return excelUtils.exportToExcel(sheetName, list, fields, fieldNames, new ReadObjectValue() {
			public Object readValue(int row, int column, Object srcObj) {
				return srcObj;
			}
		});
	}

	public InputStream getBorrowerPointClearExcelInputStream(List<VZhstPointClearExcelView> list, String sheetName) throws IOException, SecurityException,
			IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String[] fieldNames = {
				"商户名称", "清零积分(单位:分)", "税点", "税后金额(单位:分)", "申请时间", "状态", "入账户名", "入账账号", "入账银行名称", "手机"
		};
		String[] fields = new String[] {
				"borrowerName", "clearAmount", "taxStr", "realAmount", "applyTimeStr", "statusStr", "payeeName", "payeeAccount", "payeeAccountBank",
				"payeePhone"
		};
		ExcelUtils excelUtils = new ExcelUtils();
		return excelUtils.exportToExcel(sheetName, list, fields, fieldNames, new ReadObjectValue() {
			public Object readValue(int row, int column, Object srcObj) {
				return srcObj;
			}
		});
	}

	public InputStream getUserExcelInputStream(List<ZhstPUserInfo> list, String sheetName) throws IOException, SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String[] fieldNames = {
				"客户名称", "账户可用余额(单位:分)", "账户余额(单位:分)"
		};
		String[] fields = new String[] {
				"name", "availableIncomeAmount", "totalIncomeAmount"
		};
		ExcelUtils excelUtils = new ExcelUtils();
		return excelUtils.exportToExcel(sheetName, list, fields, fieldNames, new ReadObjectValue() {
			public Object readValue(int row, int column, Object srcObj) {
				return srcObj;
			}
		});
	}

	public InputStream getUserTradeDetailExcelInputStream(List<BorrowerAndUserIncomeView> list, String sheetName) throws IOException, SecurityException,
			IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String[] fieldNames = {
				"商铺主名称", "商铺子名称", "门店名称", "交易积分(单位:分)", "交易类型"
		};
		String[] fields = new String[] {
				"storeName", "storeShortName", "shopName", "changeValue", "changeTypeDesc"
		};
		ExcelUtils excelUtils = new ExcelUtils();
		return excelUtils.exportToExcel(sheetName, list, fields, fieldNames, new ReadObjectValue() {
			public Object readValue(int row, int column, Object srcObj) {
				return srcObj;
			}
		});
	}

	public InputStream getUserIncomeExtractMonthBillExcelInputStream(List<PointUserIncomeExtractMonthBillView> list, String sheetName) throws IOException,
			SecurityException,
			IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String[] fieldNames = {
				"客户名称", "身份证", "提现积分(单位:分)", "税后金额(单位:分)", "缴税金额(单位:分)"
		};
		String[] fields = new String[] {
				"name", "idNo", "extractAmount", "realAmount", "taxAmount"
		};
		ExcelUtils excelUtils = new ExcelUtils();
		return excelUtils.exportToExcel(sheetName, list, fields, fieldNames, new ReadObjectValue() {
			public Object readValue(int row, int column, Object srcObj) {
				return srcObj;
			}
		});
	}

}
