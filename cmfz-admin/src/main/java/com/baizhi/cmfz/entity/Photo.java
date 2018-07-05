package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/5.
 */
public class Photo implements Serializable{

    private String photoId;
    private String photoName;
    private String description;
    private Integer status;
    private Date uploadTime;

    public Photo() {
        this.photoId = UUID.randomUUID().toString().replace("-", "");
        this.status = 0;
    }

    public Photo(String description, Integer status, Date uploadTime) {
        this.description = description;
        this.status = status;
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId='" + photoId + '\'' +
                ", photoName='" + photoName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", uploadTime=" + uploadTime +
                '}';
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
