package com.sap.report.entity;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-20  13:47
 */
public class Screen {

    String excelName;
    //produce所在列
    char screenProduce;

    public Screen(String excelName, char screenProduce) {
        this.excelName = excelName;
        this.screenProduce = screenProduce;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public char getScreenProduce() {
        return screenProduce;
    }

    public void setScreenProduce(char screenProduce) {
        this.screenProduce = screenProduce;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "excelName='" + excelName + '\'' +
                ", screenProduce=" + screenProduce +
                '}';
    }
}
