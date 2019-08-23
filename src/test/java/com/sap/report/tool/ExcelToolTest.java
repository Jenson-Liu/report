package com.sap.report.tool;


import com.sap.report.pojo.unique_eCATT;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-09  09:56
 */
public class ExcelToolTest {

    @Test
    public void allreportList() {
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        for(unique_eCATT unique_eCATT:list){
            System.out.println(unique_eCATT.toString());
        }
    }

    @Test
    public void testRow() throws Exception {
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/1_Unique_eCATT.xlsx", "eCATT");
        int num = ExcelTool.getAllRowNum(sheet);
        System.out.println(num);
    }

    @Test
    public void testAllRow(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        ArrayList<String> rownames = ExcelTool.getAllRowName(sheet);
        for (String name:rownames){
            System.out.println(name);
        }
    }

    @Test
    public void testAllRow2(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/1_Unique_eCATT.xlsx", "eCATT");
        ArrayList<String> rownames = ExcelTool.getAllRowName(sheet);
        for (String name:rownames){
            System.out.println(name);
        }
    }
}
