package com.sap.report.controller;

import com.sap.report.Result.AjaxVO;
import com.sap.report.service.RedisService;
import com.sap.report.service.lipsService;
import com.sap.report.tool.ExcelTool;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author : Jenson.Liu
 * @date : 8/29/19  2:31 下午
 */
@Controller
@RequestMapping("/report")
public class PercentController {

    private static final Logger logger = LoggerFactory.getLogger(PercentController.class);

    @Autowired
    RedisService redisService;

    @Autowired
    lipsService lipsService;

    /**
     * 获取针对M列的饼图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/BCSet/getPercentby1911",method = RequestMethod.GET)
    public AjaxVO showPerent(){
        Sheet sheet = ExcelTool.getSheet("2_BC_Set.xlsx", "BC-Set");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'M','J');
        for (String s:list){
            logger.info(s);
        }
        int rownum = ExcelTool.getAllRowNum(sheet);
        logger.info("rownum:"+rownum);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                if(sheet.getRow(i).getCell(lipsService.ChartoNum('M')).getStringCellValue().equals(s)
                        &&sheet.getRow(i).getCell(lipsService.ChartoNum('J')).getStringCellValue().equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * 获取针对I列的饼图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/BCSet/getPercentbyLob",method = RequestMethod.GET)
    public AjaxVO showPerentByLob(){
        Sheet sheet = ExcelTool.getSheet("2_BC_Set.xlsx", "BC-Set");
        LinkedHashMap<String, ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'I','J');
        int rownum = ExcelTool.getAllRowNum(sheet);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                if(sheet.getRow(i).getCell(lipsService.ChartoNum('I')).getStringCellValue().equals(s)
                        &&sheet.getRow(i).getCell(lipsService.ChartoNum('J')).getStringCellValue().equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * TransportableCCF获取针对M列的饼图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/TransportableCCF/getPercentby1911",method = RequestMethod.GET)
    public AjaxVO showTransportableCCFPerent(){
        Sheet sheet = ExcelTool.getSheet("5_Not_Transportable_CCF.xlsx", "Not_Transportable");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'T','Q');
        int rownum = ExcelTool.getAllRowNum(sheet);
        logger.info("rownum:"+rownum);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                String cellname = null;
                try {
                    cellname = sheet.getRow(i).getCell(lipsService.ChartoNum('T')).getStringCellValue();
                }catch (NullPointerException e){
                    cellname = "null";
                }

                if(cellname.equals(s)
                        &&sheet.getRow(i).getCell(lipsService.ChartoNum('Q')).getStringCellValue().equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * 文件3的饼图，针对L列
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Tables/getPercent",method = RequestMethod.GET)
    public AjaxVO showTablesPerent(){
        Sheet sheet = ExcelTool.getSheet("3_E_Tables_CCF.xlsx", "E-Tables");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'L','K');
        int rownum = ExcelTool.getAllRowNum(sheet);
        logger.info("rownum:"+rownum);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                String cellname = null;
                try {
                    cellname = sheet.getRow(i).getCell(lipsService.ChartoNum('L')).getStringCellValue();
                }catch (NullPointerException e){
                    cellname = "null";
                }

                if(cellname.equals(s)
                        &&sheet.getRow(i).getCell(lipsService.ChartoNum('K')).getStringCellValue().equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * 文件6的饼图，针对L列
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Whitelist/getPercent",method = RequestMethod.GET)
    public AjaxVO showWhitelistPerent(){
        Sheet sheet = ExcelTool.getSheet("6_Client000_Whitelist_Tables.xlsx", "Tables");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'M','K');
        int rownum = ExcelTool.getAllRowNum(sheet);
        logger.info("rownum:"+rownum);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                String cellname = null;
                try {
                    cellname = sheet.getRow(i).getCell(lipsService.ChartoNum('M')).getStringCellValue();
                }catch (NullPointerException e){
                    cellname = "null";
                }

                if(cellname.equals(s)
                        &&sheet.getRow(i).getCell(lipsService.ChartoNum('K')).getStringCellValue().equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * 文件7的饼图，针对K列
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/CustObjects/getPercent",method = RequestMethod.GET)
    public AjaxVO showCustObjectsPercent(){
        Sheet sheet = ExcelTool.getSheet("7_CustObjects_L_T_CCF.xlsx", "CustObjects_L_T_CCF");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'R','P');
        int rownum = ExcelTool.getAllRowNum(sheet);
        logger.info("rownum:"+rownum);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                String cellname = null;
                try {
                    cellname = sheet.getRow(i).getCell(lipsService.ChartoNum('R')).getStringCellValue();
                }catch (NullPointerException e){
                    cellname = "null";
                }
                String name = null;
                try {
                    name = sheet.getRow(i).getCell(lipsService.ChartoNum('P')).getStringCellValue();
                }catch (NullPointerException e){
                    name = "null";
                }
                if(cellname.equals(s)
                        &&name.equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * 文件8的饼图，针对K列
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/CustomizingObjects/getPercent",method = RequestMethod.GET)
    public AjaxVO showCustomizingObjectsPercent(){
        Sheet sheet = ExcelTool.getSheet("8_CustomizingObjects_with_Events_or_modified_UIs.xlsx", "PoC Worklist - Cust.Objects");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        int rownum = ExcelTool.getAllRowNum(sheet,'I');
        ArrayList<String> list = lipsService.getScreenMap(sheet,'K','I',rownum);
        logger.info("rownum:"+rownum);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                String cellname = null;
                try {
                    cellname = sheet.getRow(i).getCell(lipsService.ChartoNum('K')).getStringCellValue();
                }catch (NullPointerException e){
                    cellname = "null";
                }
                String name = null;
                try {
                    name = sheet.getRow(i).getCell(lipsService.ChartoNum('I')).getStringCellValue();
                }catch (NullPointerException e){
                    name = "null";
                }
                catch (IllegalStateException e2){
                    name = "null";
                }
                if(cellname.equals(s)
                        &&name.equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(3).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

}
