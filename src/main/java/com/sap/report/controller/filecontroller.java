package com.sap.report.controller;

import com.sap.report.service.RedisService;
import com.sap.report.tool.Filetool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-12  16:17
 */
@Controller
@RequestMapping("/report/file")
public class filecontroller {

    @Autowired
    RedisService redisService;

    private static final Logger logger = LoggerFactory.getLogger(filecontroller.class);
    /**
     *
     * @param files
     */
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(@RequestParam("file") MultipartFile... files) throws IOException {
        ArrayList<File> fileArrayList = Filetool.MultipartFiletoFile(files);
        System.out.println(fileArrayList.get(0).getName());
        redisService.setValue("currentFile",fileArrayList.get(0).getName());
    }

    @RequestMapping("/uploadecatt")
    public String uploadecatt(){
        return "FileUpload";
    }

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public void uploadecatts(@RequestParam("bar") String name){
        System.out.println(name);
    }
}
