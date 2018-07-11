package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
 * @program: cmfz
 * @description: 管理员
 * @author: yp
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/man")
public class ManagerController{

    @Autowired
    private ManagerService ms;

    /**
     * @Description 管理员登录
     * @Author yp
     * @Param name:管理员名称, password:密码, statu:是否记住姓名, rememberMe:7天免登录, request:获得session作用域, response:将数据写入Cookie
     * @Exception Exception
     */
    @RequestMapping("/login")
    public String login(String name, String password, boolean statu, boolean rememberMe, HttpServletResponse response, HttpServletRequest request) throws Exception {
        //在web环境中安全管理器会自动进行初始化
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(name, password, rememberMe));

            Manager manager = ms.queryManager(name);

            if(manager != null){
                if(statu){
                    Cookie cookieName = new Cookie("name", URLEncoder.encode(name, "utf-8"));
                    cookieName.setMaxAge(60*60*24*7);
                    response.addCookie(cookieName);

                    request.getSession().setAttribute("manager", manager);
                }
            }
            return "main";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "login";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return "login";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        }
    }

    /**
     * @Description 登出
     * @Author yp
     * @Param request:获得session作用域
     * @Exception Exception
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) throws Exception {

        Manager manager = (Manager)request.getSession().getAttribute("name");
        if(manager != null){
            request.getSession().setAttribute("manager", null);
        }
        return "login";
    }

    /**
     * @Description 管理员注册
     * @Author yp
     * @Param name:名称, password:密码
     * @Exception Exception
     */
    @RequestMapping("/regist")
    @ResponseBody
    public String regist(String name, String password) throws Exception {

        boolean flag =  ms.addManager(name, password);

        if(flag){
            return "success";
        }
        return "error";
    }

    /**
     * @Description 验证验证码
     * @Author yp
     * @Param session:作用域, code:验证码
     * @Exception Exception
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(String code,HttpSession session) throws Exception{

        if (code != null && code.equals(session.getAttribute("code"))){
            return "验证码正确";
        }
        return "验证码错误";
    }

    /**
     * @Description 查询所有文章
     * @Author yp
     * @Param request:获得session作用域, map:将数据存入Cookie
     * @Exception Exception
     */
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
