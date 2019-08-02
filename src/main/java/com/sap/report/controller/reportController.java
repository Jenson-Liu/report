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
 * @date : 2019-07-26  15:06
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
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
        String ecattmigrationtorc;
        String ecattnomigration;
        String ecattforceimg;
        String ecattmulttype;
        ArrayList<unique_eCATT> listecattmigrationtorc = new ArrayList<>();
        ArrayList<unique_eCATT> listecattnomigration = new ArrayList<>();
        ArrayList<unique_eCATT> listecattforceimg = new ArrayList<>();
        ArrayList<unique_eCATT> listecattmulttype = new ArrayList<>();
        ecattService.getbylobcommitmentstatus(list);
        int size = list.size();
        logger.info("size:"+size);
        HashMap<String, ArrayList<unique_eCATT>> hashMap = ecattService.getbyClassification(list);
        listecattmigrationtorc = hashMap.get("ECATT_MIGRATION_TO_RC");
        listecattnomigration = hashMap.get("ECATT_NO_MIGRATION");
        listecattforceimg =  hashMap.get("ECATT_FORCE_IMG");
        listecattmulttype = hashMap.get("ECATT_MULT_TYPE");
        ecattmigrationtorc = unique_eCATTPro.getProbability(listecattmigrationtorc,size);
        ecattnomigration = unique_eCATTPro.getProbability(listecattnomigration,size);
        ecattforceimg = unique_eCATTPro.getProbability(listecattforceimg,size);
        ecattmulttype = unique_eCATTPro.getProbability(listecattmulttype,size);
        ArrayList<eCATTPercent> listpercent = new ArrayList<>();
        listpercent.add(new eCATTPercent(listecattmigrationtorc.size(),ecattmigrationtorc));
        listpercent.add(new eCATTPercent(listecattnomigration.size(),ecattnomigration));
        listpercent.add(new eCATTPercent(listecattforceimg.size(),ecattforceimg));
        listpercent.add(new eCATTPercent(listecattmulttype.size(),ecattmulttype));
        AjaxVO ajaxVO = new AjaxVO(true, "success", listpercent);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getPercentbyLob",method = RequestMethod.GET)
    public AjaxVO showPercentbyLob(){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
        String ce1908;
        String ce1911;
        String obsoltete;
        String centralbc;
        String ignored;
        String clarification;
        ArrayList<unique_eCATT> list1908 = new ArrayList<>();
        ArrayList<unique_eCATT> list1911 = new ArrayList<>();
        ArrayList<unique_eCATT> listobsolete = new ArrayList<>();
        ArrayList<unique_eCATT> listCentral = new ArrayList<>();
        ArrayList<unique_eCATT> listignored = new ArrayList<>();
        ArrayList<unique_eCATT> listclarification = new ArrayList<>();
        ecattService.getbylobcommitmentstatus(list);
        int size = list.size();
        logger.info("size:"+size);
        HashMap<String, ArrayList<unique_eCATT>> hashMap = ecattService.getbylobcommitmentstatus(list);
        list1908 = hashMap.get("Scheduled for CE 1908");
        list1911 = hashMap.get("Scheduled for CE 1911");
        listobsolete =  hashMap.get("Object obsolete");
        listCentral = hashMap.get("To be solved by Central BC");
        listignored = hashMap.get("Can currently be ignored");
        listclarification = hashMap.get("In clarification");
        ce1908 = unique_eCATTPro.getProbability(list1908,size);
        ce1911 = unique_eCATTPro.getProbability(list1911,size);
        obsoltete = unique_eCATTPro.getProbability(listobsolete,size);
        centralbc = unique_eCATTPro.getProbability(listCentral,size);
        ignored = unique_eCATTPro.getProbability(listignored,size);
        clarification = unique_eCATTPro.getProbability(listclarification,size);
        ArrayList<eCATTPercent> listpercent = new ArrayList<>();
        listpercent.add(new eCATTPercent(list1908.size(),ce1908));
        listpercent.add(new eCATTPercent(list1911.size(),ce1911));
        listpercent.add(new eCATTPercent(listobsolete.size(),obsoltete));
        listpercent.add(new eCATTPercent(listCentral.size(),centralbc));
        listpercent.add(new eCATTPercent(listignored.size(),ignored));
        listpercent.add(new eCATTPercent(listclarification.size(),clarification));
        AjaxVO ajaxVO = new AjaxVO(true, "success", listpercent);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getPercentbyClasseach/{type}",method = RequestMethod.GET)
    public AjaxVO showPercentbyClasseach(@PathVariable("type") String type){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
        ArrayList<unique_eCATT> listunique = new ArrayList<>();
        HashMap<String, ArrayList<unique_eCATT>> hashMap = ecattService.getbyClassification(list);
        listunique = hashMap.get(type);
        AjaxVO ajaxVO = new AjaxVO(true, "success", listunique);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getPercentbyClasseach",method = RequestMethod.GET)
    public AjaxVO showPercentbyClassAll(){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
        AjaxVO ajaxVO = new AjaxVO(true, "success", list);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getPercentbyLobeach/{type}",method = RequestMethod.GET)
    public AjaxVO showPercentbyLobeach(@PathVariable("type") String type){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
        ArrayList<unique_eCATT> listpercent = new ArrayList<>();
        HashMap<String, ArrayList<unique_eCATT>> hashMap = ecattService.getbylobcommitmentstatus(list);
        listpercent = hashMap.get(type);
        AjaxVO ajaxVO = new AjaxVO(true, "success", listpercent);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getPercentbyLobeach",method = RequestMethod.GET)
    public AjaxVO showPercentbyLobAll(){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
        AjaxVO ajaxVO = new AjaxVO(true, "success", list);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/getAlllist",method = RequestMethod.GET)
    public AjaxVO showAlllist(){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
        AjaxVO ajaxVO = new AjaxVO(true, "success", list);
        return ajaxVO;
    }

    @ResponseBody
    @RequestMapping(value = "/geteachone",method = RequestMethod.GET)
    public AjaxVO showAlllistByaccid(@RequestParam("actid") String actid){
        System.out.println("actid:"+actid);
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
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

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
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

    @ResponseBody
    @RequestMapping(value = "/getListone/{name}",method = RequestMethod.GET)
    public AjaxVO getListone(@PathVariable("name") String name){
        ArrayList<unique_eCATT> list = ExcelTool.AllreportList("ExcelFiles/1_Unique_eCATT.xlsx", "eCATT",15);
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
