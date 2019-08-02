package com.sap.report.service;

import com.sap.report.pojo.unique_eCATT;
import com.sap.report.tool.ExcelTool;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-29  15:25
 */
public class ecattServiceTest {

    @Resource
    ecattService ecattService;

    @Test
    public void getbyClassification() {
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
//        for(unique_eCATT unique_eCATT : list){
//            System.out.println(unique_eCATT.toString());
//        }
        HashMap<String, ArrayList<unique_eCATT>> hashMap = ecattService.getbyClassification(list);

    }
}