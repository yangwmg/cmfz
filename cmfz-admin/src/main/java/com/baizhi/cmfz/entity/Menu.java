package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public class Menu implements Serializable{

    private Integer menuId;
    private String menuName;
    private String menuCode;
    private String menuIcon;
    private String menuURL;
    private Integer menuLevel;
    private Integer parentId;
    private List<Menu> mes;

    public Menu() {
    }

    public Menu(Integer menuId, String menuName, String menuCode, String menuIcon, String menuURL, Integer menuLevel, Integer parentId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuIcon = menuIcon;
        this.menuURL = menuURL;
        this.menuLevel = menuLevel;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuURL='" + menuURL + '\'' +
                ", menuLevel=" + menuLevel +
                ", parentId=" + parentId +
                ", mes=" + mes +
                '}';
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuURL() {
        return menuURL;
    }

    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getMes() {
        return mes;
    }

    public void setMes(List<Menu> mes) {
        this.mes = mes;
    }
}
