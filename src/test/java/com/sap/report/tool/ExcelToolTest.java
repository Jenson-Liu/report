package com.sap.report.tool;

import com.sap.report.pojo.unique_eCATT;
import org.junit.Test;

import javax.imageio.IIOException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-26  11:28
 */
public class ExcelToolTest {

    @Test
    public void LOBIndex() {
        System.out.println(ExcelTool.LOBIndex("ExcelFiles/1_Unique_eCATT.xlsx","eCATT"));
    }

    @Test
    public void testMap() throws IOException {
        LinkedHashMap<String,String> map = ExcelTool.reportMap("ExcelFiles/1_Unique_eCATT.xlsx","eCATT",15,19);
        for(String key:map.keySet()){
            System.out.println(key+"--------"+map.get(key));
        }
    }

    @Test
    public void testNum() throws Exception {
        System.out.println(ExcelTool.getAllRow("ExcelFiles/1_Unique_eCATT.xlsx","eCATT"));
    }

    @Test
    public void getAlllist(){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
        for(unique_eCATT unique_eCATT : list){
            System.out.println(unique_eCATT.toString());
        }
    }

    @Test
    public void getResult(){
        int num1 = 7;

        int num2 = 9;

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) num1 / (float) num2 * 100);

        System.out.println("num1和num2的百分比为:" + result + "%");
    }
}