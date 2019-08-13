package com.sap.report.pojo;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-30  14:04
 */
public class eCATTPercent {
    int num;
    String percent;

    public eCATTPercent(int num, String percent) {
        this.num = num;
        this.percent = percent;
    }
    public eCATTPercent(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "eCATTPercent{" +
                "num=" + num +
                ", percent='" + percent + '\'' +
                '}';
    }
}
