package com.sap.report.service;

import com.sap.report.pojo.unique_eCATT;
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

    public HashMap<String,ArrayList<unique_eCATT>> getbyClassification(ArrayList<unique_eCATT> list){
        HashMap<String,ArrayList<unique_eCATT>> hashMap = new HashMap<>();
        ArrayList<unique_eCATT> ecattmigrationtorc = new ArrayList<>();
        ArrayList<unique_eCATT> ecattnomigration = new ArrayList<>();
        ArrayList<unique_eCATT> ecattforceimg = new ArrayList<>();
        ArrayList<unique_eCATT> ecattmulttype = new ArrayList<>();
        for (unique_eCATT unique_eCATT:list){
            if(unique_eCATT.getEcattclassificationdonebylob().contains("ECATT_MIGRATION_TO_RC")){
                ecattmigrationtorc.add(unique_eCATT);
            }else if(unique_eCATT.getEcattclassificationdonebylob().contains("ECATT_NO_MIGRATION")){
                ecattnomigration.add(unique_eCATT);
            }else if(unique_eCATT.getEcattclassificationdonebylob().contains("ECATT_FORCE_IMG")){
                ecattforceimg.add(unique_eCATT);
            }else{
                ecattmulttype.add(unique_eCATT);
            }
        }
        hashMap.put("ECATT_MIGRATION_TO_RC",ecattmigrationtorc);
        hashMap.put("ECATT_NO_MIGRATION",ecattnomigration);
        hashMap.put("ECATT_FORCE_IMG",ecattforceimg);
        hashMap.put("ECATT_MULT_TYPE",ecattmulttype);
        return hashMap;
    }

    public HashMap<String,ArrayList<unique_eCATT>> getbylobcommitmentstatus(ArrayList<unique_eCATT> list){
        HashMap<String,ArrayList<unique_eCATT>> hashMap = new HashMap<>();
        ArrayList<unique_eCATT> list1908 = new ArrayList<>();
        ArrayList<unique_eCATT> list1911 = new ArrayList<>();
        ArrayList<unique_eCATT> listobsolete = new ArrayList<>();
        ArrayList<unique_eCATT> listCentral = new ArrayList<>();
        ArrayList<unique_eCATT> listignored = new ArrayList<>();
        ArrayList<unique_eCATT> listclarification = new ArrayList<>();
        for (unique_eCATT unique_eCATT:list){
            if(unique_eCATT.getLoccommitmentstatuspubliccloud1911().contains("Scheduled for CE 1908")){
                list1908.add(unique_eCATT);
            }else if(unique_eCATT.getLoccommitmentstatuspubliccloud1911().contains("Scheduled for CE 1911")){
                list1911.add(unique_eCATT);
            }else if(unique_eCATT.getLoccommitmentstatuspubliccloud1911().contains("Object obsolete")){
                listobsolete.add(unique_eCATT);
            }else if(unique_eCATT.getLoccommitmentstatuspubliccloud1911().contains("To be solved by Central BC")) {
                listCentral.add(unique_eCATT);
            }else if(unique_eCATT.getLoccommitmentstatuspubliccloud1911().contains("Can currently be ignored")) {
                listignored.add(unique_eCATT);
            }else {
                listclarification.add(unique_eCATT);
            }
        }
        hashMap.put("Scheduled for CE 1908",list1908);
        hashMap.put("Scheduled for CE 1911",list1911);
        hashMap.put("Object obsolete",listobsolete);
        hashMap.put("To be solved by Central BC",listCentral);
        hashMap.put("Can currently be ignored",listignored);
        hashMap.put("In clarification",listclarification);
        return hashMap;
    }

    public ArrayList<unique_eCATT> getbyBoth(ArrayList<unique_eCATT> list,String selectClass,String selectLob){
        ArrayList<unique_eCATT> listClass = new ArrayList<>();
        ArrayList<unique_eCATT> listLob = new ArrayList<>();
        if(selectClass != null){
            for(unique_eCATT unique_eCATT:list){
                if(unique_eCATT.getEcattclassificationdonebylob().contains(selectClass)){
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
