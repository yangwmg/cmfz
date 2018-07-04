package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.utils.CreateValidateCodeUtil;
import com.baizhi.cmfz.utils.EncryptionUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Test1 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerDao md = (ManagerDao)ac.getBean("managerDao");

        Manager manager = new Manager();
        manager.setName("tom");
        String salt = new CreateValidateCodeUtil(200,50,6).getCode();
        manager.setPassword(EncryptionUtil.encryptionCode("123"+salt));
        manager.setSalt(salt);

        System.out.println(manager);

        md.insertManager(manager);
    }
}
