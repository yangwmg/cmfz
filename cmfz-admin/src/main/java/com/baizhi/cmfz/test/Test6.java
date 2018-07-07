package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.PhotoDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.Photo;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.PhotoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Test6 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        PhotoDao pd = (PhotoDao)ac.getBean("photoDao");

        List<Photo> photos = pd.selectAllPhoto(1, 5);
        int count = pd.count();

        System.out.println(count);
        System.out.println(photos);
        for(Photo photo : photos){
            System.out.println("-----");
            System.out.println(photo);
        }
    }
}
