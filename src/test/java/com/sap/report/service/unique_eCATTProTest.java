package com.sap.report.service;

import org.junit.Test;
import java.util.ArrayList;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-09  11:03
 */
public class unique_eCATTProTest {


    @Test
    public void getAllType() {
        ArrayList<String> list = unique_eCATTPro.getAllecattclassificationce1911donebylob("src/main/resources/1_Unique_eCATT.xlsx");
        for(String test:list){
            System.out.println(test);
        }
    }


    @Test
    public void getAllTypeLob() {
        ArrayList<String> list = unique_eCATTPro.getAllLoccommitmentstatuspubliccloud1911("src/main/resources/1_Unique_eCATT.xlsx");
        for(String test:list){
            System.out.println(test);
        }
    }
}
