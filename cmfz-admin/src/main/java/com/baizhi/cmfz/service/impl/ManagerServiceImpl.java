package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.utils.CreateValidateCodeUtil;
import com.baizhi.cmfz.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public Manager queryManager(String name, String password) {

        Manager manager = md.selectManager(name);

        if(manager != null && manager.getPassword().equals(EncryptionUtil.encryptionCode(password + manager.getSalt()))){
            return manager;
        }
        return null;
    }

    @Override
    public boolean addManager(String name, String password) {

        String salt = new CreateValidateCodeUtil(200,50,6).getCode();
        Manager manager = new Manager(name, password, salt);

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
