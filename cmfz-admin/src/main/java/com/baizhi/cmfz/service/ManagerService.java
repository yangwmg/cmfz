package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;

import java.util.List;

public interface ManagerService {

	public Manager queryManager(String name);

	public List<SysRole> queryRolesByName(String name);

	public List<SysPermission> queryPermissionsByName(String name);

	public boolean addManager(String name, String password);
	
	public boolean removeManager(String id);
	
	public boolean modifyManager(Manager manager);

}
