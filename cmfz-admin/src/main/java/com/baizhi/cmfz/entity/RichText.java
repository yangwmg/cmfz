package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/8.
 */
public class RichText implements Serializable{

    private Integer errno;
    private String[] data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
