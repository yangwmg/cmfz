package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

public interface ArticleService {

	public Map<String, Object> queryArticle(Integer nowPage, Integer pageSize);

	public Article queryArticle(String articleId);

	public boolean addArticle(String articleName, String author, String content);

}
