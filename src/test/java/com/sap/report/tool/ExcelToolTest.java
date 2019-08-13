package com.sap.report.tool;


import com.sap.report.pojo.unique_eCATT;
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
}
