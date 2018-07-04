package com.baizhi.cmfz.test;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Test2 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerService ms = (ManagerService)ac.getBean("managerServiceImpl");

        Manager manager = ms.queryManager("tom", "123");

        System.out.println(manager);

    }
}
