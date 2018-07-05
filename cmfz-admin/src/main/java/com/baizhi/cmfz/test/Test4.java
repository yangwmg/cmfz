package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Test4 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        MenuService ms = (MenuService)ac.getBean("menuServiceImpl");

        List<Menu> menus = ms.queryMenuOne();

        for(Menu menu : menus){
            System.out.println(menu);
        }
    }
}
