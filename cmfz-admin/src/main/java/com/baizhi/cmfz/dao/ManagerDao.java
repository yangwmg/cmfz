package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerDao {

	public int insertManager(Manager manager);
	
	public int deleteManager(String id);
	
	public int updateManager(Manager manager);
	
	public Manager selectManager(String name);

	public List<SysRole> selectRolesByName(String name);

	public List<SysPermission> selectPermissionsByName(String name);

}
