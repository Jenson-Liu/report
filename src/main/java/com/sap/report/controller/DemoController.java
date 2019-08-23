package com.sap.report.controller;

import com.sap.report.mapper.MainMapper;
import com.sap.report.tool.Filetool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-15  14:04
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    MainMapper mainMapper;

    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public String testFile(){
        return "FileUpload";
    }

    @RequestMapping(value = "/name",method = RequestMethod.GET)
    @ResponseBody
    public String Testname(){
        return "hello";
    }


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Test(){
        return "axios";
    }



    @RequestMapping(value = "getValue",method = RequestMethod.GET)
    @ResponseBody
    public String show(){
        List<Character> list = mainMapper.getMainColumn("2_BC_Set");
        for (char x:list){
            System.out.println(x);
        }
        return list.toString();
    }
}
