/**
 * 
 */
package cn.ly.mlc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ly.mlc.entity.BizException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import common.util.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import cn.ly.mlc.entity.BizException;

/**
 * @author niexin
 *
 */
public class ExcelUtil {

	public static HSSFWorkbook buildHssfWordbookFromMap(String sheetName, List<String> headNames, List<Map<String, String>> dataList) {
		HSSFWorkbook excel = new HSSFWorkbook();
		// 创建表
		// 1.创建一个工作薄
		HSSFSheet sheet = excel.createSheet(sheetName);
		// 5.设置标题
		HSSFRow title = sheet.createRow(0);
		for (int i = 0; i < headNames.size(); i++) {
			HSSFCell cell = title.createCell(i);
			cell.setCellValue(headNames.get(i));
		}
		if (dataList.size() > 0) {
			for (int i = 0; i < dataList.size(); i++) {
				HSSFRow row = sheet.createRow(i + 1);
				Map<String, String> data = dataList.get(i);
				for (int j = 0; j < headNames.size(); j++) {
					String key = headNames.get(j);
					HSSFCell cell = row.createCell(j);
					if (data.containsKey(key)) {
						cell.setCellValue(data.get(key));
					} else {
						cell.setCellValue("");
					}
				}
			}
		}
		return excel;
	}

	public static void readExcelXlsFileToMap(InputStream inputStream, List<String> headNames, List<Map<String, String>> dataList) throws IOException {
		HSSFWorkbook hw = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = hw.getSheetAt(0);
		for (int j = 0; j <= sheet.getLastRowNum(); j++) {
			HSSFRow row = sheet.getRow(j);
			if (j == 0) {
				for (int k = 0; k <= row.getLastCellNum(); k++) {
					String headName = readCellStringValue(row.getCell(k));
					if (!StringUtils.isNullOrEmpty(headName)) {
						headNames.add(headName);
					} else {
						break;
					}
				}
			} else {
				Map<String, String> data = new HashMap<String, String>();
				for (int k = 0; k < headNames.size(); k++) {
					data.put(headNames.get(k), readCellStringValue(row.getCell(k)));
				}
				dataList.add(data);
			}
		}
		hw.close();

	}

	public static HSSFWorkbook buildHssfWordbook(String sheetName, List<String> headNames, List<List<String>> dataList) {
		HSSFWorkbook excel = new HSSFWorkbook();
		// 创建表
		// 1.创建一个工作薄
		HSSFSheet sheet = excel.createSheet(sheetName);
		// 列宽自动调整
		// 5.设置标题
		HSSFRow title = sheet.createRow(0);
		for (int i = 0; i < headNames.size(); i++) {
			HSSFCell cell = title.createCell(i);
			cell.setCellValue(headNames.get(i));
		}
		if (dataList.size() > 0) {
			for (int i = 0; i < dataList.size(); i++) {
				HSSFRow row = sheet.createRow(i + 1);
				List<String> data = dataList.get(i);
				for (int j = 0; j < data.size(); j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellValue(data.get(j));
				}
			}
		}
		return excel;
	}

	public static HSSFWorkbook buildHssfWordbookBySpecialTitle(String sheetName, List<String> headNames, List<List<String>> dataList, String excelTitle) {
		HSSFWorkbook excel = new HSSFWorkbook();
		// 创建表
		// 1.创建一个工作薄
		HSSFSheet sheet = excel.createSheet(sheetName);
		// 列宽自动调整
		// 5.设置标题
		// 增加一行标题
		HSSFRow title1 = sheet.createRow(0);
		HSSFCell cell1 = title1.createCell(0);
		cell1.setCellValue(excelTitle);
		HSSFRow title = sheet.createRow(1);
		for (int i = 0; i < headNames.size(); i++) {
			HSSFCell cell = title.createCell(i);
			cell.setCellValue(headNames.get(i));
		}
		if (dataList.size() > 0) {
			for (int i = 0; i < dataList.size(); i++) {
				HSSFRow row = sheet.createRow(i + 2);
				List<String> data = dataList.get(i);
				for (int j = 0; j < data.size(); j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellValue(data.get(j));
				}
			}
		}
		return excel;
	}

	public static void readExcelFile(InputStream inputStream,String fType, List<String> headNames, List<List<String>> dataList,Integer headIndex) throws IOException, BizException {
		headIndex = headIndex==null? 0 : headIndex;
		if("xls".equals(fType)){
			HSSFWorkbook hw = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = hw.getSheetAt(0);
			for (int j = 0; j <= sheet.getLastRowNum(); j++) {
				HSSFRow row = sheet.getRow(j);
				if (j == headIndex) {
					for (int k = 0; k <= row.getLastCellNum(); k++) {
						String headName = readCellStringValue(row.getCell(k)).toLowerCase();
						if (!StringUtils.isNullOrEmpty(headName)) {
							headNames.add(headName);
						} else {
							break;
						}
					}
				} else {
					List<String> data = new ArrayList<String>();
					for (int k = 0; k < headNames.size(); k++) {
						data.add(readCellStringValue(row.getCell(k)));
					}
					dataList.add(data);
				}
			}
			hw.close();
		}else if("xlsx".equals(fType)){
			XSSFWorkbook xw = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = xw.getSheetAt(0);
			for (int j = 0; j <= sheet.getLastRowNum(); j++) {
				XSSFRow row = sheet.getRow(j);
				if (j == headIndex) {
					for (int k = 0; k <= row.getLastCellNum(); k++) {
						String headName = readCellStringValue(row.getCell(k)).toLowerCase();
						if (!StringUtils.isNullOrEmpty(headName)) {
							headNames.add(headName);
						} else {
							break;
						}
					}
				} else {
					List<String> data = new ArrayList<String>();
					for (int k = 0; k < headNames.size(); k++) {
						data.add(readCellStringValue(row.getCell(k)));
					}
					dataList.add(data);
				}
			}
			xw.close();
		}else{
			throw new BizException("无效的文件格式");
		}
	}

	public static List<List<String>> readExcelXlsFile(String fileName) throws IOException {
		FileInputStream is = new FileInputStream(fileName);
		List<List<String>> result = readExcelXlsFile(is);
		is.close();
		return result;
	}

	public static List<List<String>> readExcelXlsFile(InputStream inputStream) throws IOException {
		List<List<String>> result = new ArrayList<List<String>>();
		HSSFWorkbook hw = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = hw.getSheetAt(0);
		for (int j = 0; j <= sheet.getLastRowNum(); j++) {
			HSSFRow row = sheet.getRow(j);
			List<String> items = new ArrayList<String>();
			for (int k = 0; k <= row.getLastCellNum(); k++) {
				String headName = readCellStringValue(row.getCell(k));
				if (!StringUtils.isNullOrEmpty(headName)) {
					items.add(headName);
				} else {
					items.add("");
				}
			}
			result.add(items);
		}
		hw.close();
		return result;
	}

	public static String readCellStringValue(XSSFCell cell) {
		if (cell == null)
			return "";
		if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
			return "";
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			if (cell.getBooleanCellValue()) {
				return "1";
			} else {
				return "0";
			}
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_ERROR) {
			return "";
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
			return cell.getStringCellValue().trim();
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			long longVal = Math.round(cell.getNumericCellValue());
			double doubleVal = cell.getNumericCellValue();
			if (Double.parseDouble(longVal + ".0") == doubleVal) {
				return longVal + "";
			} else {
				return new DecimalFormat("#0.0").format(cell.getNumericCellValue());
			}
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			return cell.getStringCellValue().trim();
		}
		return "";
	}

	public static String readCellStringValue(HSSFCell cell) {
		if (cell == null)
			return "";
		if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
			return "";
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			if (cell.getBooleanCellValue()) {
				return "1";
			} else {
				return "0";
			}
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_ERROR) {
			return "";
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
			return cell.getStringCellValue().trim();
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			long longVal = Math.round(cell.getNumericCellValue());
			double doubleVal = cell.getNumericCellValue();
			if (Double.parseDouble(longVal + ".0") == doubleVal) {
				return longVal + "";
			} else {
				return new DecimalFormat("#0.0").format(cell.getNumericCellValue());
			}
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			return cell.getStringCellValue().trim();
		}
		return "";
	}

	public static HSSFWorkbook buildHssfWordbookEx(String sheetName, List<String> headNames, List<List<String>> dataList, List<String> headName1List) {
		HSSFWorkbook excel = new HSSFWorkbook();
		// 创建表
		// 1.创建一个工作薄
		HSSFSheet sheet = excel.createSheet(sheetName);

		// 设置第一行标题
		HSSFRow title1 = sheet.createRow(0);
		for (int i = 0; i < headName1List.size(); i++) {
			HSSFCell cell = title1.createCell(i);
			cell.setCellValue(headName1List.get(i));
		}

		// 5.设置第二行标题标题
		HSSFRow title2 = sheet.createRow(1);
		for (int i = 0; i < headNames.size(); i++) {
			HSSFCell cell = title2.createCell(i);
			cell.setCellValue(headNames.get(i));
		}
		if (dataList.size() > 0) {
			for (int i = 0; i < dataList.size(); i++) {
				HSSFRow row = sheet.createRow(i + 2);
				List<String> data = dataList.get(i);
				for (int j = 0; j < data.size(); j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellValue(data.get(j));
				}
			}
		}
		return excel;
	}

}
