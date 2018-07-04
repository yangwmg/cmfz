package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

public interface ManagerService {

	public Manager queryManager(String name, String password);

	public boolean addManager(String name, String password);
	
	public boolean removeManager(String id);
	
	public boolean modifyManager(Manager manager);

}
