package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
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
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao md;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public List<Menu> queryMenuOne() {

        List<Menu> menus = md.selectAllMenuOne();

        if(!menus.isEmpty()){
            return menus;
        }
        return null;
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public List<Menu> queryMenuByOne(Integer menuId) {

        List<Menu> menus = md.selectAllMenuByOne(menuId);

        if(!menus.isEmpty()){
            return menus;
        }
        return null;
    }

    @Override
    public boolean addMenu(Menu menu) {

        int result = md.insertMenu(menu);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMenu(Integer menuId) {

        int result = md.deleteMenu(menuId);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyMenu(Menu menu) {

        int result = md.updateMenu(menu);

        if(result != 0){
            return true;
        }
        return false;
    }

}
