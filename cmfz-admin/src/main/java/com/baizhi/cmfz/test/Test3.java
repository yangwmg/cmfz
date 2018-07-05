package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.utils.CreateValidateCodeUtil;
import com.baizhi.cmfz.utils.EncryptionUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Test3 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        MenuDao md = (MenuDao)ac.getBean("menuDao");

        List<Menu> menus = md.selectAllMenuOne();

        for(Menu menu : menus){
            System.out.println(menu);
        }
    }
}
