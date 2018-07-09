package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/8.
 */
public class RichText implements Serializable{

    private Integer errno;
    private ArrayList<String> data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
