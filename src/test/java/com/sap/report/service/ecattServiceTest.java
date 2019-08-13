package com.sap.report.service;

import com.sap.report.pojo.unique_eCATT;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-09  11:52
 */
public class ecattServiceTest {

    @Test
    public void getbylobcommitmentstatus() {
        ecattService ecattService = new ecattService();
        HashMap<String, ArrayList<unique_eCATT>> hashMap = ecattService.getbylobcommitmentstatus();
        for(String key:hashMap.keySet()){
            System.out.println(key);
            for(unique_eCATT unique_eCATT:hashMap.get(key)){
                System.out.println(unique_eCATT);
            }
        }
    }

    @Test
    public void getbyclassification1911donebylob() {
        ecattService ecattService = new ecattService();
        HashMap<String, ArrayList<unique_eCATT>> hashMap = ecattService.getbyclassification1911donebylob();
        for(String key:hashMap.keySet()){
            System.out.println(key);
            for(unique_eCATT unique_eCATT:hashMap.get(key)){
                System.out.println(unique_eCATT);
            }
        }
    }
}