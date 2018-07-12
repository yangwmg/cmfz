package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.utils.CreateValidateCodeUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerDao md;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public Manager queryManager(String name) {

        Manager manager = md.selectManager(name);

        if(manager != null){
            return manager;
        }
        return null;
    }

    @Override
    public List<SysRole> queryRolesByName(String name) {

        List<SysRole> roles = md.selectRolesByName(name);

        return roles;
    }

    @Override
    public List<SysPermission> queryPermissionsByName(String name) {

        List<SysPermission> permissions = md.selectPermissionsByName(name);

        return permissions;
    }

    @Override
    public boolean addManager(String name, String password) {

        String salt = new CreateValidateCodeUtil(200,50,6).getCode();
        Manager manager = new Manager(name, new Md5Hash(password,salt,512).toString(), salt);
        //manager.setPassword(new Md5Hash(password,salt,512).toString());

        int result = md.insertManager(manager);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeManager(String id) {

        int result = md.deleteManager(id);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyManager(Manager manager) {

        int result = md.updateManager(manager);

        if(result != 0){
            return true;
        }
        return false;
    }

}
