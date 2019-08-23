package com.sap.report.entity;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-20  13:44
 */
public class Chart {

    String excelName;
    char chartColumn;

    public Chart(String excelName, char chartColumn) {
        this.excelName = excelName;
        this.chartColumn = chartColumn;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public char getChartColumn() {
        return chartColumn;
    }

    public void setChartColumn(char chartColumn) {
        this.chartColumn = chartColumn;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "excelName='" + excelName + '\'' +
                ", chartColumn=" + chartColumn +
                '}';
    }
}
