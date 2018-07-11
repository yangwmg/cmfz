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
 * @program: cmfz
 * @description: 轮播图
 * @author: yp
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService ps;

    /**
     * @Description 查询所有轮播图
     * @Author yp
     * @Param nowPage:当前页码, pageSize:每页显示行数
     * @Exception Exception
     */
    @RequestMapping("/allPhoto")
    @ResponseBody
    public Map<String, Object> allPhoto(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize) throws Exception {

        return ps.queryPhoto(nowPage, pageSize);
    }

    /**
     * @Description 删除轮播图
     * @Author yp
     * @Param photoId:要删除的轮播图ID
     * @Exception Exception
     */
    @RequestMapping(value="/remove")
    @ResponseBody
    public void remove(@RequestParam("photoId")String photoId) throws Exception {

        ps.removePhoto(photoId);
    }

    /**
     * @Description 修改轮播图信息
     * @Author yp
     * @Param 新的轮播图信息
     * @Exception Exception
     */
    @RequestMapping(value="/update")
    @ResponseBody
    public void update(@RequestParam("photoId")String photoId, @RequestParam("description")String description, @RequestParam("status")Integer status, @RequestParam("photoName")String photoName) throws Exception {

        ps.modifyPhoto(photoId, description, status, photoName);
    }

    /**
     * @Description 添加轮播图
     * @Author yp
     * @Param 表单提交的轮播图信息, session:作用域, myFile:上传轮播图图片
     * @Exception Exception
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public void add(MultipartFile myFile, HttpSession session, @RequestParam("description")String description, @RequestParam("status")Integer status) throws Exception {

        String realPath = session.getServletContext().getRealPath("/");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String subString1 = realPath.substring(0, lastIndexOf);
        lastIndexOf = subString1.lastIndexOf("\\");
        String subString2 = subString1.substring(0, lastIndexOf);
        String uploadPath = subString2 + "\\upload";

        String photoName = myFile.getOriginalFilename();

        myFile.transferTo(new File(uploadPath + "/" +photoName));

        ps.addPhoto(description, status, photoName);
    }

}
