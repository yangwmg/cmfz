package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService ms;

    @RequestMapping("/allMaster")
    @ResponseBody
    public Map<String, Object> allMaster(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize) throws Exception {

        return ms.queryMaster(nowPage, pageSize);
    }

    @RequestMapping("/showMasterByName")
    @ResponseBody
    public Map<String, Object> showMasterByName(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize, @RequestParam("value")String value) throws Exception {
        System.out.println(nowPage);
        System.out.println(pageSize);
        System.out.println(value);
        return ms.queryMasterByName(nowPage, pageSize, value);
    }

    @RequestMapping(value="/remove")
    @ResponseBody
    public void remove(@RequestParam("masterId")String masterId) throws Exception {

        ms.removeMaster(masterId);
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public void update(@RequestParam("masterId")String masterId, @RequestParam("masterName")String masterName, @RequestParam("masterAge")Integer masterAge, @RequestParam("masterPhoto")String masterPhoto, @RequestParam("masterSummery")String masterSummery) throws Exception {

        ms.modifyMaster(masterId, masterName, masterAge, masterPhoto, masterSummery);
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(MultipartFile myFile, HttpSession session, @RequestParam("masterId")String masterId, @RequestParam("masterName")String masterName, @RequestParam("masterAge")Integer masterAge, @RequestParam("masterSummery")String masterSummery) throws Exception {

        String realPath = session.getServletContext().getRealPath("/");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String subString1 = realPath.substring(0, lastIndexOf);
        lastIndexOf = subString1.lastIndexOf("\\");
        String subString2 = subString1.substring(0, lastIndexOf);
        String uploadPath = subString2 + "\\upload";

        String masterPhoto = myFile.getOriginalFilename();

        myFile.transferTo(new File(uploadPath + "/" +masterPhoto));

        ms.addMaster(masterId, masterName, masterAge, masterPhoto, masterSummery);
    }

}
