package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDao {

	public int insertManager(Manager manager);
	
	public int deleteManager(String id);
	
	public int updateManager(Manager manager);
	
	public Manager selectManager(String name);

}
