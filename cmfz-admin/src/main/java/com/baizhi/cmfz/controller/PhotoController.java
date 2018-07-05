package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

        return ps.queryPhoto(nowPage, pageSize);
    }

    @RequestMapping(value="/remove")
    @ResponseBody
    public void remove(@RequestParam("photoId")String photoId) throws Exception {

        ps.removePhoto(photoId);
    }

}
