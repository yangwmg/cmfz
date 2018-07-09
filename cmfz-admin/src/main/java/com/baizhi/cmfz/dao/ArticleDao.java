package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/8.
 */
@Repository
public interface ArticleDao {

    public int insertArticle(Article article);

    public int count();

    public Article selectArticle(String articleId);

    public List<Article> selectAllArticle(@Param("begin")Integer begin, @Param("end")Integer end);

}
