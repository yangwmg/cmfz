package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/9.
 */
public class ECharts implements Serializable{

    private ArrayList<String> intervals;
    private ArrayList<Integer> counts;

    public ArrayList<String> getIntervals() {
        return intervals;
    }

    public void setIntervals(ArrayList<String> intervals) {
        this.intervals = intervals;
    }

    public ArrayList<Integer> getCounts() {
        return counts;
    }

    public void setCounts(ArrayList<Integer> counts) {
        this.counts = counts;
    }
}
