package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 额外功能类
 *
 * Created by Administrator on 2018/7/9.
 */
@Aspect
public class MyLog {

    @Autowired
    private LogDao ld;

    /**
     * 声明切入点表达式
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*Impl.add*(..)) || execution(* com.baizhi.cmfz.service.impl.*Impl.modify*(..)) || execution(* com.baizhi.cmfz.service.impl.*Impl.remove*(..))")
    public void pc(){}

    /**
     * 环绕通知方法
     */
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 获取Session
        HttpSession session = request.getSession();

        // 获取用户名
        Manager manager = (Manager) session.getAttribute("manager");

        Log log = new Log();

        log.setUser(manager.getName());
        log.setTime(new Date());

        String totalArg = null;
        //获取参数
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            totalArg += arg;
            totalArg += ",";
        }
        log.setMessage(totalArg);

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 获取方法对象
        Method method = methodSignature.getMethod();
        // 获取方法名称
        String methodName = method.getName();

        String firstCode = methodName.substring(0,1);

        if(firstCode.equals("a")) {
            log.setAction("添加");
        }else if(firstCode.equals("m")) {
            log.setAction("修改");
        }else{
            log.setAction("删除");
        }

        // 获取方法所在的类
        String oldName = methodSignature.getDeclaringTypeName();
        System.out.println(oldName);
        String suffix = oldName.substring(oldName.lastIndexOf(".") + 1);
        String suffix2 = suffix.substring(0, suffix.indexOf("Service"));
        log.setResource(suffix2);

        Object obj = null;
        try{
            obj = pjp.proceed();
            log.setResult("success");
        }catch(Exception e) {
            e.printStackTrace();
            log.setResult("error");
        }
        System.out.print(log);
        ld.insertLog(log);

        return obj;
    }
}
