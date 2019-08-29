package com.sap.report.controller;

import com.sap.report.Result.AjaxVO;
import com.sap.report.service.RedisService;
import com.sap.report.service.lipsService;
import com.sap.report.tool.ExcelTool;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author : Jenson.Liu
 * @date : 8/28/19  2:14 下午
 */

@Controller
@RequestMapping("/report/Detail")
public class DetailController {

    @Autowired
    RedisService redisService;

    @Autowired
    com.sap.report.service.lipsService lipsService;

    @RequestMapping(value = "/tableShow",method = RequestMethod.GET)
    public String getPage(@RequestParam("id") String id){
        return "detailTable.html";
    }

    @ResponseBody
    @RequestMapping(value = "/getDetail",method = RequestMethod.GET)
    public AjaxVO getDetail(@RequestParam("id") String id){
        String fileName = redisService.getValue("visit-file");
        String sheetName = redisService.getSheet(fileName,"sheet").toString();
        int index = Integer.parseInt(redisService.getSheet(fileName,"index").toString().trim());
        Sheet sheet = ExcelTool.getSheet(fileName, sheetName);
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        if(fileName.equals("8_CustomizingObjects_with_Events_or_modified_UIs.xlsx")) {
            hashMap = lipsService.getDeatil(sheet, id, index,'I');
        }else {
            hashMap = lipsService.getDeatil(sheet, id, index);
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }
}
