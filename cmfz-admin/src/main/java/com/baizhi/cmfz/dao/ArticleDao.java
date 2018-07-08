package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/7/8.
 */
@Repository
public interface ArticleDao {

    public int insertArticle(Article article);

}
