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
        return "reportBC";
    }

    /**
     * 进入Unique主页
     * @return
     */
    @RequestMapping(value = "/Unique/welcome",method = RequestMethod.GET)
    public String WelcomeUnique(){
        return "reportUnique";
    }

    /**
     * 进入reportTransportableCCF主页
     * @return
     */
    @RequestMapping(value = "/TransportableCCF/welcome",method = RequestMethod.GET)
    public String WelcomereportTransportableCCF(){
        return "reportTransportableCCF";
    }

    /**
     * 进入reportTransportableCCF筛选主页
     * @return
     */
    @RequestMapping(value = "/TransportableCCF/filter",method = RequestMethod.GET)
    public String WelcomereportTransportableCCFFilter(){
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


}
