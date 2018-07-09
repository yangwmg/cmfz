package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
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

    @RequestMapping("/allMaster2")
    @ResponseBody
    public List<Master> allMaster2() throws Exception {

        return ms.queryMaster2();
    }

    @RequestMapping("/showMasterByName")
    @ResponseBody
    public Map<String, Object> showMasterByName(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize, @RequestParam("value")String value) throws Exception {

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

    @RequestMapping(value="/addMore", method = RequestMethod.POST)
    @ResponseBody
    public void addMore(MultipartFile myFile) throws Exception {

        ImportParams importParams = new ImportParams();

        List<Master> masters = ExcelImportUtil.importExcel(myFile.getInputStream(), Master.class, importParams);

        ms.addMasters(masters);
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws Exception {

        List<Master> masters = ms.queryMaster();

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("c118","上师信息表"), Master.class, masters);

        ServletOutputStream out = response.getOutputStream();

        String fileName = new String("上师信息.xls".getBytes(), "iso-8859-1");

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename="+fileName);

        workbook.write(out);
        out.close();
    }
}
