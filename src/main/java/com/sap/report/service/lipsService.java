package com.sap.report.service;

import com.sap.report.Result.AjaxVO;
import com.sap.report.controller.FileController;
import com.sap.report.pojo.unique_eCATT;
import com.sap.report.tool.ExcelTool;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-14  10:14
 */
@Service
public class lipsService {

    private static final Logger logger = LoggerFactory.getLogger(lipsService.class);


    /**
     * 获取大写字母对应的阿拉伯数字
     * @param index
     * @return
     */
    public int ChartoNum(char index){
        int num = (int)index - 65;
        return num;
    }

    /**
     *
     * @param sheet
     * @param option
     * @param index
     * @return
     */
    public ArrayList<String> getScreenMap(Sheet sheet, char option, char index) {
        int optionNum = (int)option - 65;
        int indexNum = (int)index - 65;
        ArrayList<String> resultlist = new ArrayList<>();
        ArrayList<String> newlist = new ArrayList<>();
        int rownum = ExcelTool.getAllRowNum(sheet);
        for (int i=1; i<rownum; i++) {
            String indexname = null;
            try {
                indexname = sheet.getRow(i).getCell(indexNum).getStringCellValue().toLowerCase();
            }catch (NullPointerException e){
                indexname = "null";
            }
            if ("produce".equals(indexname)) {
                try {
                    resultlist.add(sheet.getRow(i).getCell(optionNum).getStringCellValue());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
        for (String cd:resultlist) {
            if (!newlist.contains(cd)) {
                newlist.add(cd);
            }
        }
        return newlist;
    }

    /**
     * 获取指定的指定列下的
     * option的所有不同类型
     * @param sheet
     * @param option
     * @param index
     * @return
     */
    public ArrayList<String> getScreenMap(Sheet sheet, String option, String index) {
        int optionNum = (int)option.charAt(0) - 65;
        int indexNum = (int)index.charAt(0) - 65;
        ArrayList<String> resultlist = new ArrayList<>();
        ArrayList<String> newlist = new ArrayList<>();
        int rownum = ExcelTool.getAllRowNum(sheet);
        for (int i=1; i<rownum; i++) {
            String indexname = null;
            try {
                indexname = sheet.getRow(i).getCell(indexNum).getStringCellValue().toLowerCase();
                logger.info(indexname);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            if ("produce".equals(indexname)) {
                try {
                    resultlist.add(sheet.getRow(i).getCell(optionNum).getStringCellValue());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
        for (String cd:resultlist) {
            if (!newlist.contains(cd)) {
                newlist.add(cd);
            }
        }
        return newlist;
    }

    /**
     * 获取指定列的所有数据
     * @param sheet
     * @param index
     * @return
     */
    public ArrayList<String> getScreenMap(Sheet sheet, char index) {
        int indexNum = (int)index - 65;
        ArrayList<String> resultlist = new ArrayList<>();
        int rownum = ExcelTool.getAllRowNum(sheet);
        for (int i=1; i<rownum; i++) {
            try {
                resultlist.add(sheet.getRow(i).getCell(indexNum).getStringCellValue());
            }catch (NullPointerException e){
                resultlist.add("");
            }
        }
        return resultlist;
    }

    /**
     * 指定第一行获取所有数据
     * @param sheet
     * @param firstRow
     * @return
     */
    public LinkedHashMap<String,String> getDeatil(Sheet sheet, String firstRow){
        LinkedHashMap<String,String> hashMap = new LinkedHashMap<>();
        ArrayList<String> RowNames = ExcelTool.getAllRowName(sheet);
        int rownum = ExcelTool.getAllRowNum(sheet);
        for (int i=1; i<rownum; i++) {
            if(firstRow.equals(sheet.getRow(i).getCell(0).getStringCellValue())){
                for (int j=0; j<RowNames.size(); j++){
                    try {
                        hashMap.put(RowNames.get(j),sheet.getRow(i).getCell(j).getStringCellValue());
                    }catch (NullPointerException e){
                        hashMap.put(RowNames.get(j),"");
                    }
                }
                break;
            }
        }
        return hashMap;
    }

    /**
     *
     * @param sheet
     * @param firstRow
     * @param index
     * @return
     */
    public LinkedHashMap<String,String> getDeatil(Sheet sheet, String firstRow, int index){
        LinkedHashMap<String,String> hashMap = new LinkedHashMap<>();
        ArrayList<String> RowNames = ExcelTool.getAllRowName(sheet);
        int rownum = ExcelTool.getAllRowNum(sheet);
        for (int i=1; i<rownum; i++) {
            if(firstRow.equals(sheet.getRow(i).getCell(index).getStringCellValue())){
                for (int j=0; j<RowNames.size(); j++){
                    try {
                        hashMap.put(RowNames.get(j),sheet.getRow(i).getCell(j).getStringCellValue());
                    }catch (NullPointerException e){
                        hashMap.put(RowNames.get(j),"");
                    }
                }
                break;
            }
        }
        return hashMap;
    }

    /**
     * 第三个参数是设置获取字母列
     * 并返回自己需要的列
     * @param sheet
     * @param index
     * @param cloumns
     * @return
     */
    public LinkedHashMap<String,ArrayList<String>> Alllist(Sheet sheet,char index,ArrayList<Character> cloumns){
        int indexNum = (int)index - 65;
        LinkedHashMap<String,ArrayList<String>> hashMap = new LinkedHashMap<>();

        int rownum = ExcelTool.getAllRowNum(sheet);
        System.out.println("rownum:"+rownum);
        for (int i=1; i<rownum; i++) {
            ArrayList<String> resultlist = new ArrayList<>();
            String indexname = null;
            try {
                indexname = sheet.getRow(i).getCell(indexNum).getStringCellValue().toLowerCase();
            }catch (NullPointerException e){
                indexname = "null";
            }
            if ("produce".equals(indexname)) {
                try {
                    for(char cloumn:cloumns){
                        resultlist.add(sheet.getRow(i).getCell(ChartoNum(cloumn)).getStringCellValue());
                    }
                    hashMap.put(sheet.getRow(i).getCell(0).getStringCellValue(),resultlist);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    /**
     *   第三个参数是设置获取字母列
     *   并返回自己需要的列
     * @param sheet
     * @param index
     * @param cloumns
     * @param key
     * @return
     */
    public LinkedHashMap<String,ArrayList<String>> Alllist(Sheet sheet,char index,ArrayList<Character> cloumns,int key){
        int indexNum = (int)index - 65;
        LinkedHashMap<String,ArrayList<String>> hashMap = new LinkedHashMap<>();

        int rownum = ExcelTool.getAllRowNum(sheet);
        for (int i=1; i<rownum; i++) {
            ArrayList<String> resultlist = new ArrayList<>();
            String indexname = null;
            try {
                indexname = sheet.getRow(i).getCell(indexNum).getStringCellValue().toLowerCase();
            }catch (NullPointerException e){
                indexname = "null";
            }
            if ("produce".equals(indexname)) {
                try {
                    for(char cloumn:cloumns){
                        resultlist.add(sheet.getRow(i).getCell(ChartoNum(cloumn)).getStringCellValue());
                    }
                    hashMap.put(sheet.getRow(i).getCell(key).getStringCellValue(),resultlist);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }


}
