package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: cmfz
 * @description: 日志
 * @author: yp
 * Created by Administrator on 2018/7/4.
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService ls;

    /**
     * @Description 查询所有日志
     * @Author yp
     * @Param nowPage:当前页码, pageSize:每页显示行数
     * @Exception Exception
     */
    @RequestMapping("/allLog")
    @ResponseBody
    public Map<String, Object> allPhoto(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize) throws Exception {

        return ls.queryLog(nowPage, pageSize);
    }

}
