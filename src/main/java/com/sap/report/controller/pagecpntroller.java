package com.sap.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-09  16:38
 */
@Controller
@RequestMapping("/report")
public class pagecpntroller {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Welcome(){
        return "report";
    }

    @RequestMapping(value = "/Class",method = RequestMethod.GET)
    public String getAlllist(){
        return "alllistClass";
    }

    @RequestMapping(value = "/Lob",method = RequestMethod.GET)
    public String getAlllistLob(){
        return "alllistLob";
    }

    @RequestMapping(value = "/tableshow",method = RequestMethod.GET)
    public String showTable(@RequestParam("id") String id){
        return "table.html";
    }
}
