package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/man")
public class ManagerController{

    @Autowired
    private ManagerService ms;

    @RequestMapping("/login")
    public String login(String name, String password, boolean statu, HttpServletResponse response, HttpServletRequest request) throws Exception {

        Manager manager = ms.queryManager(name, password);

        if(manager != null){
            if(statu){
                Cookie cookieName = new Cookie("name", URLEncoder.encode(name, "utf-8"));
                cookieName.setMaxAge(60*60*24*7);
                response.addCookie(cookieName);

                request.getSession().setAttribute("manager", manager);
            }
            return "main";
        }
        return "login";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) throws Exception {

        Manager manager = (Manager)request.getSession().getAttribute("name");
        if(manager != null){
            request.getSession().setAttribute("manager", null);
        }
        return "login";
    }

    @RequestMapping("/regist")
    @ResponseBody
    public String regist(String name, String password) throws Exception {

        boolean flag =  ms.addManager(name, password);

        if(flag){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(String code,HttpSession session) throws Exception{

        if (code != null && code.equals(session.getAttribute("code"))){
            return "验证码正确";
        }
        return "验证码错误";
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, ModelMap map) throws Exception {
        Cookie[] cookies = request.getCookies();
        String name = "";
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("name")){
                name = URLDecoder.decode(cookie.getValue(), "utf-8");
            }
        }
        map.addAttribute("name", name);
        return "login";
    }

}
