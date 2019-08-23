package com.sap.report.controller;

import com.sap.report.Result.AjaxVO;
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
public class FileController {

    @Autowired
    RedisService redisService;

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 上传文件
     * @param files
     * @throws IOException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public void upload(@RequestParam("file") MultipartFile... files) throws IOException {
        ArrayList<String> Filenames = new ArrayList<>();
        MultipartFile file = files[0];
        logger.info(file.getOriginalFilename());
        redisService.setValue("CurrentFile",file.getOriginalFilename());
        logger.info(redisService.getValue("CurrentFile"));
        ArrayList<File> fileArrayList = Filetool.MultipartFiletoFile(files);
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
