package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Photo;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/8.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao ad;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public Map<String, Object> queryArticle(Integer nowPage, Integer pageSize) {

        List<Article> articles = ad.selectAllArticle((nowPage-1)*pageSize, nowPage*pageSize-1);

        int count = ad.count();

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("total", count);
        map.put("rows", articles);

        return map;
    }

    @Override
    public Article queryArticle(String articleId) {

        Article article = ad.selectArticle(articleId);
        if(article != null){
            return article;
        }
        return null;
    }

    @Override
    public boolean addArticle(String articleName, String author, String content) {

        Article article = new Article();
        article.setArticleName(articleName);
        article.setAuthor(author);
        article.setContent(content);
        article.setReleaseTime(new Date());

        int result = ad.insertArticle(article);

        if(result != 0){
            return true;
        }
        return false;
    }
}
