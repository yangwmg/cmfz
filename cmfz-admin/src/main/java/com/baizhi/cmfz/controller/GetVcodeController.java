package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.utils.CreateValidateCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: cmfz
 * @description: 验证码
 * @author: yp
 * Created by Administrator on 2018/7/4.
 */
@Controller
public class GetVcodeController {

    /**
     * @Description 创建验证码
     * @Author yp
     * @Param request:获取session, response:调用io流写出验证码
     * @Exception ServletException, IOException
     */
    @RequestMapping("/image")
    public void image(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CreateValidateCodeUtil util = new CreateValidateCodeUtil(100,30,4);

        HttpSession session = request.getSession();
        session.setAttribute("code", util.getCode());

        util.write(response.getOutputStream());
    }
}
