package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Repository
public interface MenuDao {

    public int insertMenu(Menu menu);

    public int deleteMenu(Integer menuId);

    public int updateMenu(Menu menu);

    public List<Menu> selectAllMenuOne();

    public List<Menu> selectAllMenuByOne(Integer menuId);
}
