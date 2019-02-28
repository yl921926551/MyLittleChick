package cn.ly.mlc.entity.common;

import java.util.ArrayList;
import java.util.List;

public class ExcelData {
   private List<String> excelHeadNames = new ArrayList<String>();

   private List<List<String>> dataList = new ArrayList<List<String>>();

    public List<String> getExcelHeadNames() {
        return excelHeadNames;
    }

    public void setExcelHeadNames(List<String> excelHeadNames) {
        this.excelHeadNames = excelHeadNames;
    }

    public List<List<String>> getDataList() {
        return dataList;
    }

    public void setDataList(List<List<String>> dataList) {
        this.dataList = dataList;
    }
}
