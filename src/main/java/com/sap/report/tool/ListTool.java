package com.sap.report.tool;

import com.sap.report.pojo.unique_eCATT;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-06  13:54
 */
public class ListTool {

    public static ArrayList<unique_eCATT> getBoth(ArrayList<unique_eCATT> list1, ArrayList<unique_eCATT> list2){
        ArrayList<unique_eCATT> unique_eCATTArrayList = new ArrayList<>();
        for(int i=0; i<list1.size(); i++){
            for (int j=0; j<list2.size(); j++){
                if(list1.get(i).getAccid() == list2.get(j).getAccid()){
                    unique_eCATTArrayList.add(list1.get(i));
                }else {
                    continue;
                }
            }
        }
        return unique_eCATTArrayList;
    }
}
