package com.sap.report.controller;

import com.sap.report.Result.AjaxVO;
import com.sap.report.pojo.unique_eCATT;
import com.sap.report.service.ecattService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-16  10:12
 */
@Controller
@RequestMapping("/report")
public class ReportPercentController {

//    /**
//     * 获取5_Not_Transportable_CCF的数据
//     * 产生报表
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/getTransportableCCF")
//    public AjaxVO getTransportableCCF(){
//        HashMap<String, ArrayList<unique_eCATT>> hashMap= ecattService.getbyclassification1911donebylob();
//        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
//        return ajaxVO;
//    }
}
