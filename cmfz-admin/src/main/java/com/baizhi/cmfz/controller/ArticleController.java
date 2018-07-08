package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.RichText;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService as;

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseBody
    /*, @RequestParam("articleName")String articleName, @RequestParam("author")String author, @RequestParam("content")String content*/
    public RichText upload(@RequestParam("files")MultipartFile files, HttpServletRequest request) throws Exception {

        System.out.println(files);
        String realPath = request.getRealPath("");
        String uploadPath = realPath.substring(0, realPath.lastIndexOf("\\"))+"\\upload";
        String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(files.getOriginalFilename());
        files.transferTo(new File(uploadPath+"\\"+fileName));

        /*if(files != null && files.length != 0){
            for (MultipartFile file : files) {
                System.out.println(file);
                String realPath = request.getRealPath("");
                String uploadPath = realPath.substring(0, realPath.lastIndexOf("\\"))+"\\upload";
                String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                file.transferTo(new File(uploadPath+"\\"+fileName));
            }
        }*/

        RichText richText = new RichText();
        richText.setErrno(0);
        richText.setData(new String[]{request.getContextPath()+"upload"+fileName});
        return richText;


        //as.addArticle(articleName, author, content);
    }

}
