package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/6.
 */
public class Master implements Serializable{

    @Excel(name="上师编号")
    private String masterId;
    @Excel(name="上师法名")
    private String masterName;
    @Excel(name="年龄")
    private Integer masterAge;
    @Excel(name="上师图片")
    private String masterPhoto;
    @Excel(name="上师简介")
    private String masterSummery;

    public Master() {
    }

    public Master(String masterId, String masterName, Integer masterAge, String masterPhoto, String masterSummery) {
        this.masterId = masterId;
        this.masterName = masterName;
        this.masterAge = masterAge;
        this.masterPhoto = masterPhoto;
        this.masterSummery = masterSummery;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterAge='" + masterAge + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterSummery='" + masterSummery + '\'' +
                '}';
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public Integer getMasterAge() {
        return masterAge;
    }

    public void setMasterAge(Integer masterAge) {
        this.masterAge = masterAge;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterSummery() {
        return masterSummery;
    }

    public void setMasterSummery(String masterSummery) {
        this.masterSummery = masterSummery;
    }
}
