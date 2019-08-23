package com.sap.report.service;

import com.sap.report.tool.ExcelTool;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-14  11:47
 */
public class lipsServiceTest {

    @Test
    public void getScreenMap() {
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        lipsService lipsService = new lipsService();
        ArrayList<String> list = lipsService.getScreenMap(sheet,"M".charAt(0),"J".charAt(0));
        for (String s:list){
            System.out.println(s);
        }
    }

    @Test
    public void getScreenMap2() {
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/1_Unique_eCATT.xlsx", "eCATT");
        lipsService lipsService = new lipsService();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'Q');
        for (String s:list){
            System.out.println(s);
        }
    }

    @Test
    public void getScreenMap4() {
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/1_Unique_eCATT.xlsx", "eCATT");
        lipsService lipsService = new lipsService();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'Q');
        for (String s:list){
            System.out.println(s);
        }
    }

    @Test
    public void getScreenMap3() {
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        lipsService lipsService = new lipsService();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'H');
        for (String s:list){
            System.out.println(s);
        }
    }

    @Test
    public void getDeatil(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        lipsService lipsService = new lipsService();
        LinkedHashMap<String,String> hashMap = lipsService.getDeatil(sheet,"/SMBA0/TVCPL_B1P4_J01");
        for (String name : hashMap.keySet()){
            System.out.println(name+":"+hashMap.get(name));
        }
    }

    @Test
    public void getAlllist(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        lipsService lipsService = new lipsService();
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('M');
        list.add('I');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'J',list);
        for(String key:hashMap.keySet()){
            System.out.println(hashMap.get(key));
        }
    }

    @Test
    public void test(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/5_Not_Transportable_CCF.xlsx", "Not_Transportable");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        lipsService lipsService = new lipsService();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'T','Q');
        for (String s:list){
            System.out.print(s+":");
        }
    }

    @Test
    public void test2(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/5_Not_Transportable_CCF.xlsx", "Not_Transportable");
        lipsService lipsService = new lipsService();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'T');
        for (String s:list){
            System.out.print(s+":");
        }
    }
}