package com.sap.report.entity;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-20  13:41
 */
public class Main {
    String excelName;
    char mainColumn;

    public Main(String excelName, char mainColumn) {
        this.excelName = excelName;
        this.mainColumn = mainColumn;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public char getMainColumn() {
        return mainColumn;
    }

    public void setMainColumn(char mainColumn) {
        this.mainColumn = mainColumn;
    }

    @Override
    public String toString() {
        return "Main{" +
                "excelName='" + excelName + '\'' +
                ", mainColumn=" + mainColumn +
                '}';
    }
}
