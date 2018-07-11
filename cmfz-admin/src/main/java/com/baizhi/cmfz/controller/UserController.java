package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Agreement;
import com.baizhi.cmfz.entity.ECharts;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: cmfz
 * @description: 用户
 * @author: yp
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    /**
     * @Description 查询所有用户
     * @Author yp
     * @Param null
     * @Exception Exception
     */
    @RequestMapping("/allUser")
    @ResponseBody
    public ECharts allUser() throws Exception {

        List<User> lists = new ArrayList<User>();
        ECharts eCharts = new ECharts();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

        for(int i = 0;i < 100;i++){
            if(i % 5 == 1){
                User user = new User();
                user.setAddress("北京");
                lists.add(user);
                count1++;
            }else if(i % 5 == 2){
                User user = new User();
                user.setAddress("新疆");
                lists.add(user);
                count2++;
            }else if(i % 5 == 3){
                User user = new User();
                user.setAddress("西藏");
                lists.add(user);
                count3++;
            }else if(i % 5 == 4){
                User user = new User();
                user.setAddress("内蒙古");
                lists.add(user);
                count4++;
            }else{
                User user = new User();
                user.setAddress("四川");
                lists.add(user);
                count5++;
            }
        }
        ArrayList<String> addresss = new ArrayList<String>();
        addresss.add("北京");
        addresss.add("四川");
        addresss.add("内蒙古");
        addresss.add("西藏");
        addresss.add("新疆");
        eCharts.setIntervals(addresss);
        ArrayList<Integer> datas = new ArrayList<Integer>();
        datas.add(count1);
        datas.add(count2);
        datas.add(count3);
        datas.add(count4);
        datas.add(count5);
        eCharts.setCounts(datas);

        return eCharts;
    }

    @RequestMapping("/allM")
    @ResponseBody
    public List<Agreement> allM() throws Exception {

        List<Agreement> agreements = new ArrayList<Agreement>();
        agreements.add(new Agreement("北京", "100"));
        agreements.add(new Agreement("天津", "200"));
        agreements.add(new Agreement("青海", "300"));
        agreements.add(new Agreement("西藏", "400"));

        return agreements;
    }

    @RequestMapping("/allW")
    @ResponseBody
    public List<Agreement> allW() throws Exception {

        List<Agreement> agreements = new ArrayList<Agreement>();
        agreements.add(new Agreement("北京","200"));
        agreements.add(new Agreement("天津","230"));
        agreements.add(new Agreement("青海","300"));
        agreements.add(new Agreement("西藏","400"));

        return agreements;
    }

}