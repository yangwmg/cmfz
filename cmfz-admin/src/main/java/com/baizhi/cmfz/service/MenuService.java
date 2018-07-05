package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

public interface MenuService {

	public List<Menu> queryMenuOne();

	public List<Menu> queryMenuByOne(Integer menuId);

	public boolean addMenu(Menu menu);
	
	public boolean removeMenu(Integer menuId);
	
	public boolean modifyMenu(Menu menu);

}
