package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

public interface MasterService {

	public Map<String, Object> queryMaster(Integer nowPage, Integer pageSize);

	public List<Master> queryMaster();

	public List<Master> queryMaster2();

	public Map<String, Object> queryMasterByName(Integer nowPage, Integer pageSize, String value);

	public boolean addMaster(String masterId, String masterName, Integer masterAge, String masterPhoto, String masterSummery);
	
	public boolean removeMaster(String masterId);
	
	public boolean modifyMaster(String masterId, String masterName, Integer masterAge, String masterSummery);

	public boolean addMasters(List<Master> masters);
}
