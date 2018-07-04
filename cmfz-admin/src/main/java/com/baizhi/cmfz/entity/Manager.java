package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Manager implements Serializable{

    private String id;
    private String name;
    private String salt;
    private String password;
    private Integer status;

    public Manager() {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.status = 1;
    }

    public Manager(String name, String salt, String password) {
        this.name = name;
        this.salt = salt;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
