package com.sap.report.controller;

import com.sap.report.Result.AjaxVO;
import com.sap.report.pojo.eCATTPercent;
import com.sap.report.pojo.unique_eCATT;
import com.sap.report.service.ecattService;
import com.sap.report.service.unique_eCATTPro;
import com.sap.report.tool.ExcelTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-26  16:06
 */
@Controller
@RequestMapping("/report")
public class reportController {

    @Autowired
    ecattService ecattService;
    @Autowired
    unique_eCATTPro unique_eCATTPro;

    private static final Logger logger = LoggerFactory.getLogger(reportController.class);

    @ResponseBody
    @RequestMapping(value = "/getPercentbyClass",method = RequestMethod.GET)
    public AjaxVO showPercentbyClass(){
        HashMap<String,ArrayList<unique_eCATT>>  hashMap= ecattService.getbyclassification1911donebylob();
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getPercentbyLob",method = RequestMethod.GET)
    public AjaxVO showPercentbyLob(){
        HashMap<String,ArrayList<unique_eCATT>>  hashMap= ecattService.getbylobcommitmentstatus();
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }


    @ResponseBody
    @RequestMapping(value = "/getPercentbyClasseach",method = RequestMethod.GET)
    public AjaxVO showPercentbyClassAll(){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        AjaxVO ajaxVO = new AjaxVO(true, "success", list);
        return ajaxVO;
    }


    @ResponseBody
    @RequestMapping(value = "/getPercentbyLobeach",method = RequestMethod.GET)
    public AjaxVO showPercentbyLobAll(){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        AjaxVO ajaxVO = new AjaxVO(true, "success", list);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getAlllist",method = RequestMethod.GET)
    public AjaxVO showAlllist(){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        AjaxVO ajaxVO = new AjaxVO(true, "success", list);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getBoth",method = RequestMethod.GET)
    public AjaxVO showBoth(@RequestParam("selectClass") String selectClass,
                           @RequestParam("selectLob") String selectLob ){
        System.out.println(selectClass+":"+selectLob);
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        ArrayList<unique_eCATT> listunique = ecattService.getbyBoth(list,selectClass,selectLob);
        AjaxVO ajaxVO = new AjaxVO(true, "success", listunique);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/geteachone",method = RequestMethod.GET)
    public AjaxVO showAlllistByaccid(@RequestParam("actid") String actid){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        unique_eCATT unique_eCATTCopy = new unique_eCATT();
        for(unique_eCATT unique_eCATT: list){
            if(unique_eCATT.getAccid().equals(actid)){
                unique_eCATTCopy = unique_eCATT;
                System.out.println(unique_eCATTCopy);
                break;
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", unique_eCATTCopy);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getListone/{name}",method = RequestMethod.GET)
    public AjaxVO getListone(@PathVariable("name") String name){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("src/main/resources/1_Unique_eCATT.xlsx", "eCATT",16);
        unique_eCATT unique_eCATTIndex = new unique_eCATT();
        for(unique_eCATT unique_eCATT:list){
            if (unique_eCATT.getAccid() == name){
                unique_eCATTIndex = unique_eCATT;
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", unique_eCATTIndex);
        return ajaxVO;
    }

}
