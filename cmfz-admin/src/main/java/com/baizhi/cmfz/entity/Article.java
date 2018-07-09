package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/8.
 */
public class Article implements Serializable{

    private String articleId;
    private String articleName;
    private String author;
    private String content;
    @JSONField(format="yyyy-MM-dd")
    private Date releaseTime;

    public Article() {
        this.articleId = UUID.randomUUID().toString().replace("-", "");
    }

    public Article(String articleName, String author, String content) {
        this.articleName = articleName;
        this.author = author;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", releaseTime=" + releaseTime +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}
