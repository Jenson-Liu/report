package com.sap.report.tool;

import com.sap.report.pojo.unique_eCATT;
import com.sap.report.service.lipsService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-26  09:40
 */
public class ExcelTool {

    private static final Logger logger = LoggerFactory.getLogger(ExcelTool.class);

    /**
     * 获取指定excel文件的sheet
     * @param fileName
     * @return
     */
    public static ArrayList<String> getSheets(String fileName){
        ArrayList<String> list = new ArrayList<String>();
        File excelFile = new File("src/main/resources/static/lips/"+fileName);
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
            Iterator<Sheet> iter =  wb.sheetIterator();
            while (iter.hasNext()){
                String sheetName = iter.next().getSheetName();
                list.add(sheetName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 保证每次只读一次磁盘IO
     * 指定filename和sheet获取对应的sheet
     * @param fileName
     * @param sheetfilter
     * @return
     */
    public static Sheet getSheet(String fileName,String sheetfilter){
        FileInputStream inputStream = null;
        XSSFWorkbook wb = null;
        File excelFile = new File("src/main/resources/static/lips/"+fileName);
        try {
            inputStream = new FileInputStream(excelFile);
            wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheet(sheetfilter);
            return sheet;
        }catch (Exception e){
            logger.info("error to read");
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> getAllRowName(Sheet sheet){
        try {
            int num = 0;
            ArrayList<String> RowNames = new ArrayList<>();
            Row row = sheet.getRow(0);
            for (Cell cell:row){
                RowNames.add(cell.getStringCellValue());
            }
            return RowNames;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    public static int getAllRowNum(Sheet sheet){
        try {
            int num = 0;
            int index = 0;
            for(Row row:sheet){
                try{
                    if(row.getCell(0).getStringCellValue()!=null){
                        num++;
                    } else {
                      index++;
                    }
                    if(index == 3){
                        return num;
                    }
                }catch (NullPointerException e){
                    return num;
                }catch (IllegalStateException e1){
                    continue;
                }
            }
            return num;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 根据num
     * @param sheet
     * @return
     */
    public static int getAllRowNum(Sheet sheet,char c){
        int selectnum = (int)c - 65;
        System.out.println(selectnum);
        try {
            int num = 0;
            int index = 0;
            int i = 0;
            for(Row row:sheet){
                try{
                    if(row.getCell(selectnum).getStringCellValue()!=null){
                        num++;
                        index = 0;
                    } else {
                        index++;
                    }
                    if(index == 3){
                        return num;
                    }
                }catch (NullPointerException e){
                    num++;
                    index++;
                    if(index == 3){
                        return num;
                    }
                }catch (IllegalStateException e1){
                    continue;
                }
            }
            return num;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return -1;
    }

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
            wb.close();
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
                        unique_eCATT.setecattclassificationce1908donebylob2019(sheet.getRow(i).getCell(14).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setecattclassificationce1908donebylob2019("");
                    }
                    try {
                        unique_eCATT.setecattclassificationce1911donebylob(sheet.getRow(i).getCell(15).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setecattclassificationce1911donebylob("");
                    }
                    try {
                        unique_eCATT.setResponsiblelob(sheet.getRow(i).getCell(16).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setResponsiblelob("");
                    }
                    try {
                        unique_eCATT.setLobcomments(sheet.getRow(i).getCell(17).getStringCellValue());
                    }catch (NullPointerException e){
                        unique_eCATT.setLobcomments("");
                    }
                    try {
                        unique_eCATT.setLoccommitmentstatuspubliccloud1911(sheet.getRow(i).getCell(20).getStringCellValue());
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

    /**
     * 通过sheet，需要的字符，获取标题头
     * @param sheet
     * @param filter
     * @param index
     * @return
     */
    public static ArrayList<String> getColumnsBySheet(Sheet sheet,ArrayList<Character> filter,char index){
        ArrayList<String> list = new ArrayList<>();
        int rownum = ExcelTool.getAllRowNum(sheet,index);
        for (char c:filter){
            list.add(sheet.getRow(0).getCell(ChartoNum(c)).getStringCellValue());
        }
        return list;
    }

    public static int ChartoNum(char index){
        int num = (int)index - 65;
        return num;
    }

}
