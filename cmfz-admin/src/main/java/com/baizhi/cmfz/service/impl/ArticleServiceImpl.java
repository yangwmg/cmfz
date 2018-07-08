package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/7/8.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao ad;

    @Override
    public boolean addArticle(String articleName, String author, String content) {

        Article article = new Article();
        article.setArticleName(articleName);
        article.setAuthor(author);
        article.setContent(content);

        int result = ad.insertArticle(article);

        if(result != 0){
            return true;
        }
        return false;
    }
}
