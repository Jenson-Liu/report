package com.sap.report.entity;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-20  13:48
 */
public class Sheet {

    String excelName;
    String sheetName;

    public Sheet(String excelName, String sheetName) {
        this.excelName = excelName;
        this.sheetName = sheetName;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "excelName='" + excelName + '\'' +
                ", sheetName='" + sheetName + '\'' +
                '}';
    }
}
