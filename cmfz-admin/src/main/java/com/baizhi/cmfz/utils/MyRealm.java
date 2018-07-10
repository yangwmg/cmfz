package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.entity.Manager;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

/**
 * 自定义数据源类
 *
 * Created by Administrator on 2018/7/10.
 */
public class MyRealm extends AuthenticatingRealm{

    /**
     * 获取认证信息的方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String name = upToken.getUsername();

        Manager manager = new Manager();

        if(name.equals(manager.getName())) {

            /*if(account.isLocked()) {
                throw new LockedAccountException("Account [" + account + "] is locked.");
            }

            if(account.isCredentialsExpired()) {
                String msg = "The credentials for account [" + account + "] are expired";
                throw new ExpiredCredentialsException(msg);
            }*/

            return new SimpleAuthenticationInfo(manager.getName(), manager.getPassword(), ByteSource.Util.bytes(manager.getSalt()), UUID.randomUUID().toString());
        }
        return null;
    }
}
