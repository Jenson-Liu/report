package com.sap.report.service;

import com.sap.report.pojo.unique_eCATT;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-29  14:56
 */
@Service
public class unique_eCATTPro {

    public String getProbability(ArrayList<unique_eCATT> list,int size){
        float num= (float)list.size()/size;
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(num);
        return result;
    }
}
