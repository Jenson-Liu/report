package com.sap.report.controller;

import com.sap.report.entity.Chart;
import com.sap.report.entity.Sheet;
import com.sap.report.mapper.ChartMapper;
import com.sap.report.mapper.SheetMapper;
import com.sap.report.service.RedisService;
import com.sap.report.tool.Filetool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-09  16:38
 */
@Controller
@RequestMapping("/report")
public class PageController {

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/system")
    public String system(){
        return "systemManage";
    }

    /*
     关于新版本的修改
     */

    /**
     * 进入上传页面
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String uploadFile(){
        return "FileUpload";
    }

    /**
     * 进入筛选sheet界面
     * @return
     */
    @RequestMapping(value = "/selectSheet",method = RequestMethod.GET)
    public String selectSheet(){
        String filename = redisService.getValue("current");
        return "selectSheet";
    }

    @RequestMapping(value = "/design",method = RequestMethod.GET)
    public String design(){
        System.out.println(redisService.getValue("CurrentSheet"));
        return "design";
    }
    /*
     截止位置
     */

    /**
     *
     * @return
     */
    @RequestMapping(value = "/Unique/allList",method = RequestMethod.GET)
    public String getAlllist(){
        return "alllistUnique";
    }

    @RequestMapping(value = "/Lob",method = RequestMethod.GET)
    public String getAlllistLob(){
        return "alllistBC";
    }

    @RequestMapping(value = "/tableshow",method = RequestMethod.GET)
    public String showTable(@RequestParam("id") String id){
        return "table.html";
    }

    @RequestMapping(value = "/BCSet/allList",method = RequestMethod.GET)
    public String getAlllistBC(){
        return "alllistBC";
    }

    /**
     * 进入BCSet主页
     * @return
     */
    @RequestMapping(value = "/BCSet/welcome",method = RequestMethod.GET)
    public String welcomeBCSet(){
        redisService.setValue("visit-file","2_BC_Set.xlsx");
        return "reportBC";
    }

    /**
     * 进入Unique主页
     * @return
     */
    @RequestMapping(value = "/Unique/welcome",method = RequestMethod.GET)
    public String WelcomeUnique(){
        redisService.setValue("visit-file","1_Unique_eCATT.xlsx");
        return "reportUnique";
    }

    /**
     * 进入reportTransportableCCF主页
     * @return
     */
    @RequestMapping(value = "/TransportableCCF/welcome",method = RequestMethod.GET)
    public String WelcomereportTransportableCCF(){
        redisService.setValue("visit-file","5_Not_Transportable_CCF.xlsx");
        return "reportTransportableCCF";
    }

    /**
     * 进入Tables主页
     * @return
     */
    @RequestMapping(value = "/Tables/welcome",method = RequestMethod.GET)
    public String welcomeReportables(){
        redisService.setValue("visit-file","3_E_Tables_CCF.xlsx");
        return "reportTables";
    }

    /**
     * 进入CustObjects主页
     * @return
     */
    @RequestMapping(value = "/CustObjects/welcome",method = RequestMethod.GET)
    public String welcomeReportCustObjects(){
        redisService.setValue("visit-file","7_CustObjects_L_T_CCF.xlsx");
        return "reportCustObjects";
    }

    /**
     * 进入Whitelist主页
     * @return
     */
    @RequestMapping(value = "/Whitelist/welcome",method = RequestMethod.GET)
    public String welcomeReportWhitelist(){
        redisService.setValue("visit-file","6_Client000_Whitelist_Tables.xlsx");
        return "reportWhitelist";
    }

    /**
     * 进入CustomizingObjects主页
     * @return
     */
    @RequestMapping(value = "/CustomizingObjects/welcome",method = RequestMethod.GET)
    public String welcomeCustomizingObjects(){
        redisService.setValue("visit-file","8_CustomizingObjects_with_Events_or_modified_UIs.xlsx");
        return "reportCustomizingObjects";
    }

    /**
     * 进入reportTransportableCCF筛选主页
     * @return
     */
    @RequestMapping(value = "/TransportableCCF/filter",method = RequestMethod.GET)
    public String welcomeReportTransportableCCFFilter(){
        return "alllistTransportableCCF";
    }

    /**
     * TransportableCCF指定id的全部数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/TransportableCCF/tableshow",method = RequestMethod.GET)
    public String showTableTransportableCCF(@RequestParam("id") String id){
        return "detailTransportableCCF.html";
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "/Tables/allList",method = RequestMethod.GET)
    public String getAlllistTables(){
        return "alllistTables";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/Whitelist/allList",method = RequestMethod.GET)
    public String getAlllistWhitelist(){
        return "alllistWhitelist";
    }

    /**
     *alllistCustomizingObjects
     * @return
     */
    @RequestMapping(value = "/CustObjects/allList",method = RequestMethod.GET)
    public String getAlllistCustObjects(){
        return "alllistCustObjects";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/CustomizingObjects/allList",method = RequestMethod.GET)
    public String getAlllistCustomizingObjects(){
        return "alllistCustomizingObjects";
    }

}
