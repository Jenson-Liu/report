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
 * @date : 8/28/19  2:33 下午
 */
@Controller
@RequestMapping("/report")
public class AlllistController {

    private static final Logger logger = LoggerFactory.getLogger(AlllistController.class);

    @Autowired
    RedisService redisService;

    @Autowired
    com.sap.report.service.lipsService lipsService;

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/BCSet/Alllist",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllist(){
        Sheet sheet = ExcelTool.getSheet("2_BC_Set.xlsx", "BC-Set");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('I');
        list.add('M');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'J',list);
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/TransportableCCF/Alllist",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getTransportableCCFAlllist(){
        Sheet sheet = ExcelTool.getSheet("5_Not_Transportable_CCF.xlsx", "Not_Transportable");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('I');
        list.add('T');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'Q',list,1);
        for(String key:hashMap.keySet()){
            System.out.println(key+":"+hashMap.get(key));
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/Tables/Alllist",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllistTables(){
        Sheet sheet = ExcelTool.getSheet("3_E_Tables_CCF.xlsx", "E-Tables");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('C');
        list.add('D');
        list.add('K');
        list.add('L');
        list.add('N');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'K',list);
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/Whitelist/Alllist",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllistWhitelist(){
        Sheet sheet = ExcelTool.getSheet("6_Client000_Whitelist_Tables.xlsx", "Tables");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('M');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'K',list);
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/CustObjects/Alllist",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllistCustObjects(){
        Sheet sheet = ExcelTool.getSheet("7_CustObjects_L_T_CCF.xlsx", "CustObjects_L_T_CCF");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('D');
        list.add('G');
        list.add('H');
        list.add('R');
        list.add('Q');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'P',list,1);
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/CustomizingObjects/Alllist",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllistCustomizingObjects(){
        Sheet sheet = ExcelTool.getSheet("8_CustomizingObjects_with_Events_or_modified_UIs.xlsx", "PoC Worklist - Cust.Objects");
        ArrayList<Character> list = new ArrayList<>();
        list.add('C');
        list.add('D');
        list.add('E');
        list.add('J');
        list.add('K');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'I',list,3);
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }
}
