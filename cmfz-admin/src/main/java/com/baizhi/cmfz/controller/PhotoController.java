package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.PhotoService;
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
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService ps;

    @RequestMapping("/allPhoto")
    @ResponseBody
    public Map<String, Object> allPhoto(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize) throws Exception {

        System.out.println(ps.queryPhoto(nowPage, pageSize));
        return ps.queryPhoto(nowPage, pageSize);
    }

    @RequestMapping(value="/remove")
    @ResponseBody
    public void remove(@RequestParam("photoId")String photoId) throws Exception {

        ps.removePhoto(photoId);
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public void update(@RequestParam("photoId")String photoId, @RequestParam("description")String description, @RequestParam("status")Integer status, @RequestParam("photoName")String photoName) throws Exception {

        ps.modifyPhoto(photoId, description, status, photoName);
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public void add(MultipartFile myFile, HttpSession session, @RequestParam("description")String description, @RequestParam("status")Integer status, @RequestParam("photoName")String photoName) throws Exception {

        String realPath = session.getServletContext().getRealPath("/");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String subString1 = realPath.substring(0, lastIndexOf);
        lastIndexOf = subString1.lastIndexOf("\\");
        String subString2 = subString1.substring(0, lastIndexOf);
        String uploadPath = subString2 + "\\upload\\photos";

        myFile.transferTo(new File(uploadPath + "/" +photoName));

        ps.addPhoto(description, status, photoName);
    }

}
