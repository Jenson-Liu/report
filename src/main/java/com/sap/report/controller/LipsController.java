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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-14  14:17
 */
@Controller
@RequestMapping("/report")
public class LipsController {

    private static final Logger logger = LoggerFactory.getLogger(LipsController.class);

    @Autowired
    RedisService redisService;

    @Autowired
    lipsService lipsService;

    /**
     * 获取针对M列的饼图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/BCSet/getPercentby1911",method = RequestMethod.GET)
    public AjaxVO showPerent(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'M','J');
        for (String s:list){
            logger.info(s);
        }
        int rownum = ExcelTool.getAllRowNum(sheet);
        logger.info("rownum:"+rownum);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                if(sheet.getRow(i).getCell(lipsService.ChartoNum('M')).getStringCellValue().equals(s)
                &&sheet.getRow(i).getCell(lipsService.ChartoNum('J')).getStringCellValue().equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * 获取针对I列的饼图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/BCSet/getPercentbyLob",method = RequestMethod.GET)
    public AjaxVO showPerentByLob(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'I','J');
        int rownum = ExcelTool.getAllRowNum(sheet);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                if(sheet.getRow(i).getCell(lipsService.ChartoNum('I')).getStringCellValue().equals(s)
                        &&sheet.getRow(i).getCell(lipsService.ChartoNum('J')).getStringCellValue().equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/BCSet/Alllist",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getAlllist(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
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
     * 通过筛选自己的filter
     * @param selectLob
     * @param select1911
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/BCSet/getBoth",method = RequestMethod.GET)
    public AjaxVO showBoth(@RequestParam("selectLob") String selectLob,
                           @RequestParam("select1911") String select1911 ){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('I');
        list.add('M');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'J',list);
        LinkedHashMap<String,ArrayList<String>> result = hashMap;
        if(selectLob!=""){
            for (String key:hashMap.keySet()){
                if(!hashMap.get(key).get(2).equals(selectLob)){
                    result.remove(key);
                }
            }
        }
        if(select1911!=""){
            for (String key:hashMap.keySet()){
                if(!hashMap.get(key).get(3).equals(select1911)){
                    result.remove(key);
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", result);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/BCSet/getDetail",method = RequestMethod.GET)
    public AjaxVO getDetailbyColumn(@RequestParam("actid") String actid){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/2_BC_Set.xlsx", "BC-Set");
        lipsService lipsService = new lipsService();
        LinkedHashMap<String,String> hashMap = lipsService.getDeatil(sheet,actid);

        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }

    /**
     * 通过传入的id获取详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/BCSet/tableshow",method = RequestMethod.GET)
    public String showTable(@RequestParam("id") String id){
        return "detail.html";
    }

    /**
     * TransportableCCF获取针对M列的饼图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/TransportableCCF/getPercentby1911",method = RequestMethod.GET)
    public AjaxVO showTransportableCCFPerent(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/5_Not_Transportable_CCF.xlsx", "Not_Transportable");
        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<>();
        ArrayList<String> list = lipsService.getScreenMap(sheet,'T','Q');
        int rownum = ExcelTool.getAllRowNum(sheet);
        logger.info("rownum:"+rownum);
        for (String index:list){
            listLinkedHashMap.put(index,new ArrayList<String>());
        }
        for (int i=1; i<rownum; i++ ){
            for (String s:list){
                String cellname = null;
                try {
                    cellname = sheet.getRow(i).getCell(lipsService.ChartoNum('T')).getStringCellValue();
                }catch (NullPointerException e){
                    cellname = "null";
                }

                if(cellname.equals(s)
                        &&sheet.getRow(i).getCell(lipsService.ChartoNum('Q')).getStringCellValue().equals("Produce")){
                    listLinkedHashMap.get(s).add(sheet.getRow(i).getCell(0).getStringCellValue());
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", listLinkedHashMap);
        return ajaxVO;
    }

    /**
     * 通过字母，筛选需要的字段
     * @return
     */
    @RequestMapping(value = "/TransportableCCF/Alllist",method = RequestMethod.GET)
    @ResponseBody
    public AjaxVO getTransportableCCFAlllist(){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/5_Not_Transportable_CCF.xlsx", "Not_Transportable");
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
     *
     * @param select
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select/TransportableCCF",method = RequestMethod.GET)
    public AjaxVO showBoth(@RequestParam("select") String select){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/5_Not_Transportable_CCF.xlsx", "Not_Transportable");
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('I');
        list.add('T');
        LinkedHashMap<String,ArrayList<String>> hashMap = lipsService.Alllist(sheet,'Q',list,1);
        LinkedHashMap<String,ArrayList<String>> result = new LinkedHashMap<>();
        if(select!=""){
            for (String key:hashMap.keySet()){
                System.out.println(key);
                System.out.println(hashMap.get(key).get(4)+select+"="+hashMap.get(key).get(4).equals(select));
                if(hashMap.get(key).get(4).equals(select)){
                    result.put(key,hashMap.get(key));
                }
            }
        }
        AjaxVO ajaxVO = new AjaxVO(true, "success", result);
        return ajaxVO;
    }

    /**
     * 获取TransportableCCF指定id的详细数据
     * @param actid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/TransportableCCF/getDetail",method = RequestMethod.GET)
    public AjaxVO getDetailbyColumnTransportableCCF(@RequestParam("actid") String actid){
        Sheet sheet = ExcelTool.getSheet("src/main/resources/static/lips/5_Not_Transportable_CCF.xlsx", "Not_Transportable");
        LinkedHashMap<String,String> hashMap = lipsService.getDeatil(sheet,actid,1);
        AjaxVO ajaxVO = new AjaxVO(true, "success", hashMap);
        return ajaxVO;
    }

    /**
     * 获取当前上传文件的所有sheet
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCurrentFile")
    public AjaxVO getCurrentFile(){
        String fileName = redisService.getValue("CurrentFile");
        ArrayList<String> list =  ExcelTool.getSheets(fileName);
        AjaxVO ajaxVO = new AjaxVO(true,"sueecess",list);
        return ajaxVO;
    }

    /**
     * 获取当前上传文件的指定的sheet
     * @param sheet
     */
    @ResponseBody
    @RequestMapping(value = "/setCurrentSheet",method = RequestMethod.POST)
    public void setCurrentSheet(@RequestParam("sheet")String sheet){
        redisService.setValue("CurrentSheet",sheet);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllRows",method = RequestMethod.GET)
    public AjaxVO getAllRows(){
        Sheet sheet = ExcelTool.getSheet(redisService.getValue("CurrentFile"),redisService.getValue("CurrentSheet"));
        ArrayList<String> list = ExcelTool.getAllRowName(sheet);
        AjaxVO ajaxVO = new AjaxVO(true,"message",list);
        return ajaxVO;
    }
}
