package com.sap.report.service;

import com.sap.report.pojo.unique_eCATT;
import com.sap.report.tool.ExcelTool;
import com.sap.report.tool.ListTool;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-29  14:40
 */
@Service
@Component
public class ecattService {

    public HashMap<String,ArrayList<unique_eCATT>> getbyclassification1911donebylob(){
        ArrayList<String> resultlist = unique_eCATTPro.getAllecattclassificationce1911donebylob("src/main/resources/1_Unique_eCATT.xlsx");
        ArrayList<unique_eCATT> Alllist = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        HashMap<String,ArrayList<unique_eCATT>> hashMap = new HashMap<>();
        for (String index:resultlist){
            hashMap.put(index,new ArrayList<unique_eCATT>());
        }
        for (unique_eCATT unique_eCATT:Alllist) {
            for (String index : resultlist) {
                if (unique_eCATT.getecattclassificationce1911donebylob().contains(index)) {
                    hashMap.get(index).add(unique_eCATT);
                }
            }
        }
        return hashMap;
    }

    public HashMap<String,ArrayList<unique_eCATT>> getbylobcommitmentstatus(){
        ArrayList<String> resultlist = unique_eCATTPro.getAllLoccommitmentstatuspubliccloud1911("src/main/resources/1_Unique_eCATT.xlsx");
        ArrayList<unique_eCATT> Alllist = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        HashMap<String,ArrayList<unique_eCATT>> hashMap = new HashMap<>();
        for (String index:resultlist){
            hashMap.put(index,new ArrayList<unique_eCATT>());
        }
        for (unique_eCATT unique_eCATT:Alllist) {
            for (String index : resultlist) {
                if (unique_eCATT.getLoccommitmentstatuspubliccloud1911().contains(index)) {
                    hashMap.get(index).add(unique_eCATT);
                }
            }
        }
        return hashMap;
    }

    public ArrayList<unique_eCATT> getbyBoth(ArrayList<unique_eCATT> list,String selectClass,String selectLob){
        ArrayList<unique_eCATT> listClass = new ArrayList<>();
        ArrayList<unique_eCATT> listLob = new ArrayList<>();
        if(selectClass != null){
            for(unique_eCATT unique_eCATT:list){
                if(unique_eCATT.getecattclassificationce1911donebylob().contains(selectClass)){
                    listClass.add(unique_eCATT);
                }
            }
        }
        if(selectClass != null){
            for(unique_eCATT unique_eCATT:list){
                if(unique_eCATT.getLoccommitmentstatuspubliccloud1911().contains(selectLob)){
                    listLob.add(unique_eCATT);
                }
            }
        }
        return ListTool.getBoth(listClass,listLob);
    }
}
