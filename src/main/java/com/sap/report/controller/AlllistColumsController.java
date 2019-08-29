package com.sap.report.controller;

import com.sap.report.Result.AjaxVO;
import com.sap.report.service.RedisService;
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

/**
 * @author : Jenson.Liu
 * @date : 8/28/19  2:37 下午
 */
@Controller
@RequestMapping("/report")
public class AlllistColumsController {

    private static final Logger logger = LoggerFactory.getLogger(AlllistColumsController.class);

    @Autowired
    RedisService redisService;

    @Autowired
    com.sap.report.service.lipsService lipsService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/Tables/AlllistColumns",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllistTablesColumns(){
        Sheet sheet = ExcelTool.getSheet("3_E_Tables_CCF.xlsx", "E-Tables");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('C');
        list.add('D');
        list.add('K');
        list.add('L');
        list.add('N');
        ArrayList<String> resultlist = lipsService.getColumnsBySheet(sheet,list);
        AjaxVO ajaxVO = new AjaxVO(true, "success", resultlist);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/Whitelist/AlllistColumns",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllistWhitelistColums(){
        Sheet sheet = ExcelTool.getSheet("6_Client000_Whitelist_Tables.xlsx", "Tables");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('M');
        ArrayList<String> resultlist = lipsService.getColumnsBySheet(sheet,list);
        AjaxVO ajaxVO = new AjaxVO(true, "success", resultlist);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/CustObjects/AlllistColumns",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllistCustObjectsColumns(){
        Sheet sheet = ExcelTool.getSheet("7_CustObjects_L_T_CCF.xlsx", "CustObjects_L_T_CCF");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('D');
        list.add('G');
        list.add('H');
        list.add('R');
        list.add('Q');
        ArrayList<String> result= lipsService.getColumnsBySheet(sheet,list);
        AjaxVO ajaxVO = new AjaxVO(true, "success", result);
        return ajaxVO;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/CustomizingObjects/AlllistColumns",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllistCustomizingObjectsColumns(){
        Sheet sheet = ExcelTool.getSheet("8_CustomizingObjects_with_Events_or_modified_UIs.xlsx", "PoC Worklist - Cust.Objects");
        ArrayList<Character> list = new ArrayList<>();
        list.add('C');
        list.add('D');
        list.add('E');
        list.add('J');
        list.add('K');
        ArrayList<String> result = lipsService.getColumnsBySheet(sheet,list);
        AjaxVO ajaxVO = new AjaxVO(true, "success", result);
        return ajaxVO;
    }
}
