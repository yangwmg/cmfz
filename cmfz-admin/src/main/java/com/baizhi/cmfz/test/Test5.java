package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.PhotoDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.Photo;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Test5 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        PhotoDao pd = (PhotoDao)ac.getBean("photoDao");

        Photo photo = new Photo();
        photo.setPhotoName("l5.jpg");
        photo.setDescription("寺庙风景5");
        photo.setUploadTime(new Date());

        pd.insertPhoto(photo);
    }
}
