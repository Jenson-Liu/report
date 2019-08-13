package com.sap.report.service;

import com.sap.report.pojo.unique_eCATT;
import com.sap.report.tool.ExcelTool;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-29  14:56
 */
@Service
public class unique_eCATTPro {

    public  static String getProbability(ArrayList<unique_eCATT> list,int size){
        float num= (float)list.size()/size;
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(num);
        return result;
    }

    //获取ecattclassificationce1911donebylob所有类型
    public static ArrayList<String> getAllecattclassificationce1911donebylob(String filename) {
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList(filename, "eCATT", 16);
        ArrayList<String> resultlist = new ArrayList<>();
        ArrayList<String> newlist = new ArrayList<>();
        for (unique_eCATT unique_eCATT : list) {
            resultlist.add(unique_eCATT.getecattclassificationce1911donebylob());
        }
        for (String cd:resultlist) {
            if (!newlist.contains(cd)) {
                newlist.add(cd);
            }
        }
        return newlist;
    }

    //获取Loccommitmentstatuspubliccloud1911所有类型
    public static ArrayList<String> getAllLoccommitmentstatuspubliccloud1911(String filename) {
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList(filename, "eCATT", 16);
        ArrayList<String> resultlist = new ArrayList<>();
        ArrayList<String> newlist = new ArrayList<>();
        for (unique_eCATT unique_eCATT : list) {
            resultlist.add(unique_eCATT.getLoccommitmentstatuspubliccloud1911());
        }
        for (String cd:resultlist) {
            if (!newlist.contains(cd)) {
                newlist.add(cd);
            }
        }
        return newlist;
    }

    public static ArrayList<String> getAllLoccommitmentstatuspubliccloud1911byrealname() {
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT", 16);
        ArrayList<String> resultlist = new ArrayList<>();
        ArrayList<String> newlist = new ArrayList<>();
        for (unique_eCATT unique_eCATT : list) {
            resultlist.add(unique_eCATT.getLoccommitmentstatuspubliccloud1911());
        }
        for (String cd:resultlist) {
            if (!newlist.contains(cd)) {
                newlist.add(cd);
            }
        }
        return newlist;
    }
}
