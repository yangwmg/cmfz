package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: cmfz
 * @description: 菜单
 * @author: yp
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService ms;

    /**
     * @Description 查询所有菜单
     * @Author yp
     * @Param null
     * @Exception Exception
     */
    @RequestMapping("/allMenuOne")
    @ResponseBody
    public List<Menu> allMenuOne() throws Exception {

        List<Menu> menus = ms.queryMenuOne();

        if(!menus.isEmpty()){
            for(Menu menu : menus){
                menu.setMes(ms.queryMenuByOne(menu.getMenuId()));
            }
            return menus;
        }
        return null;
    }

}
