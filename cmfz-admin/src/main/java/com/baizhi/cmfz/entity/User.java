package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/9.
 */
public class User implements Serializable{

    private String userId;
    private String userName;
    private String legalName;
    private String password;
    private String sex;
    private String portrait;
    private String address;
    private String phone;
    private String signature;
    private Integer status;
    private String guru;

    public User() {
        this.userId = UUID.randomUUID().toString().replace("-", "");
        this.status = 1;
    }

    public User(String userId, String userName, String legalName, String password, String sex, String portrait, String address, String phone, String signature, Integer status, String guru) {
        this.userId = userId;
        this.userName = userName;
        this.legalName = legalName;
        this.password = password;
        this.sex = sex;
        this.portrait = portrait;
        this.address = address;
        this.phone = phone;
        this.signature = signature;
        this.status = status;
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", legalName='" + legalName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", portrait='" + portrait + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", signature='" + signature + '\'' +
                ", status=" + status +
                ", guru='" + guru + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGuru() {
        return guru;
    }

    public void setGuru(String guru) {
        this.guru = guru;
    }
}
