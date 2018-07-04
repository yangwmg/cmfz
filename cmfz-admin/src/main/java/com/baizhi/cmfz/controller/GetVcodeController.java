package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.utils.CreateValidateCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class GetVcodeController {

    @RequestMapping("/image")
    public void image(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CreateValidateCodeUtil util = new CreateValidateCodeUtil(100,30,4);

        HttpSession session = request.getSession();
        session.setAttribute("code", util.getCode());

        util.write(response.getOutputStream());
    }
}
