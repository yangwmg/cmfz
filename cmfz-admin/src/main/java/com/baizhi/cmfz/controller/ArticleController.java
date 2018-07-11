package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.RichText;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/**
 * @program: cmfz
 * @description: 文章
 * @author: yp
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService as;

    /**
     * @Description 查询所有文章
     * @Author yp
     * @Param nowPage:当前页码, pageSize:每页显示行数
     * @Exception Exception
     */
    @RequestMapping("/allArticle")
    @ResponseBody
    public Map<String, Object> allArticle(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize) throws Exception {

        return as.queryArticle(nowPage, pageSize);
    }

    /**
     * @Description 根据ID查询文章
     * @Author yp
     * @Param articleId:文章ID
     * @Exception Exception
     */
    @RequestMapping("/query")
    @ResponseBody
    public String query(@RequestParam("articleId")String articleId) throws Exception {
        System.out.println(as.queryArticle(articleId).getContent());
        return as.queryArticle(articleId).getContent();
    }

    /**
     * @Description 创建文章
     * @Author yp
     * @Param articleName:文章标题, author:作者, content:文章内容
     * @Exception Exception
     */
    @RequestMapping(value="/add")
    @ResponseBody
    public void add(@RequestParam("articleName")String articleName, @RequestParam("author")String author, @RequestParam("content")String content) throws Exception {

        as.addArticle(articleName, author, content);
    }

    /**
     * @Description 上传文章中的图片
     * @Author yp
     * @Param files:图片集合, request:获得当前项目路径
     * @Exception Exception
     */
    @RequestMapping(value="/upload")
    @ResponseBody
    public RichText upload(@RequestParam("files")MultipartFile[] files, HttpServletRequest request) throws Exception {

        RichText result = new RichText();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

}