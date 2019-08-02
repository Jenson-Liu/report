package com.sap.report.tool;

import com.sap.report.pojo.unique_eCATT;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-26  09:40
 */
public class ExcelTool {

    private static final Logger logger = LoggerFactory.getLogger(ExcelTool.class);

    public static LinkedHashMap<String, String> reportMap(String filename, String sheetfilter,
                                                          int lobnum, int statusnum) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        File excelFile = new File(filename);
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
            XSSFSheet sheet = wb.getSheet(sheetfilter);
            int i, j;
            logger.info("lobnum:"+lobnum);
            logger.info("statusnum:"+statusnum);
            for(i=1; i<=308;i++) {
                if (sheet.getRow(i).getCell(lobnum).getStringCellValue().contains("Produce")) {
                    map.put(sheet.getRow(i).getCell(0).getStringCellValue(),
                            sheet.getRow(i).getCell(statusnum).getStringCellValue());
                }
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    public static ArrayList<unique_eCATT> AllreportList(String filename, String sheetfilter,
                                                       int lobnum) {
        ArrayList<unique_eCATT> list = new ArrayList<>();
        File excelFile = new File(filename);
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
            XSSFSheet sheet = wb.getSheet(sheetfilter);
            int i;
            logger.info("lobnum:"+lobnum);
            for(i=1; i<=308;i++) {
                if (sheet.getRow(i).getCell(lobnum).getStringCellValue().contains("Produce")) {
                    unique_eCATT unique_eCATT = new unique_eCATT();
                    unique_eCATT.setAccid(sheet.getRow(i).getCell(0).getStringCellValue());
                    try {
                        unique_eCATT.setText((sheet.getRow(i).getCell(1).getStringCellValue()));
                    }catch (NullPointerException e){
                        unique_eCATT.setText("");
                    }
                    try {
                        unique_eCATT.setEcattcallingbcset(sheet.getRow(i).getCell(5).getStringCellValue());
                    }catch (NullPointerException e) {
                        unique_eCATT.setEcattcallingbcset("");
                    }
                    try {
                        unique_eCATT.setContainsdeliveryclassa(sheet.getRow(i).getCell(6).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setContainsdeliveryclassa("");
                    }
                    try {
                        unique_eCATT.setIntablemdascustd(sheet.getRow(i).getCell(7).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setIntablemdascustd("");
                    }
                    try {
                        unique_eCATT.setUsedonlyindemodata(sheet.getRow(i).getCell(8).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setUsedonlyindemodata("");
                    }
                    try {
                        unique_eCATT.setUsedinoponly(sheet.getRow(i).getCell(9).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setUsedinoponly("");
                    }
                    try {
                        unique_eCATT.setLobresponsibleforecatt(sheet.getRow(i).getCell(10).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setLobresponsibleforecatt("");
                    }
                    try {
                        unique_eCATT.setAbapreplacementclass(sheet.getRow(i).getCell(11).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setAbapreplacementclass("");
                    }
                    try {
                        unique_eCATT.setApplicationcomponentofrepleacementclass(sheet.getRow(i).getCell(12).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setApplicationcomponentofrepleacementclass("");
                    }
                    try {
                        unique_eCATT.setLobresponsibleforreplacementclass(sheet.getRow(i).getCell(13).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setLobresponsibleforreplacementclass("");
                    }
                    try {
                        unique_eCATT.setEcattclassificationdonebylob(sheet.getRow(i).getCell(14).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setEcattclassificationdonebylob("");
                    }
                    try {
                        unique_eCATT.setResponsiblelob(sheet.getRow(i).getCell(15).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setResponsiblelob("");
                    }
                    try {
                        unique_eCATT.setLobcomments(sheet.getRow(i).getCell(16).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setLobcomments("");
                    }
                    try {
                        unique_eCATT.setLoccommitmentstatuspubliccloud1911(sheet.getRow(i).getCell(19).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setLoccommitmentstatuspubliccloud1911("");
                    }
                    list.add(unique_eCATT);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException nullexception){
            nullexception.printStackTrace();
        }
        return list;
    }

    public static int LOBIndex(String filename, String sheetfilter) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        File excelFile = new File(filename);
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
            XSSFSheet sheet = wb.getSheet(sheetfilter);
            int i, j;
            for (Cell cell : sheet.getRow(0)) {
                if (cell.getStringCellValue().contains("Responsible LoB")) {
                    return cell.getColumnIndex();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getAllRow(String filename,String sheetfilter) throws Exception{
        File excelFile = new File(filename);
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
        XSSFSheet sheet = wb.getSheet("sheetfilter");
        int num = 0;
        for (Row row : sheet) {
            if(row.getCell(0).getStringCellValue() !=""){
                num++;
            }
        }
        return num;
    }
}
