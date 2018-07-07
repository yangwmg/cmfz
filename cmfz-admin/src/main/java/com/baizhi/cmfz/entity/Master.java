package com.baizhi.cmfz.entity;

/**
 * Created by Administrator on 2018/7/6.
 */
public class Master {

    private String masterId;
    private String masterName;
    private Integer masterAge;
    private String masterPhoto;
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
