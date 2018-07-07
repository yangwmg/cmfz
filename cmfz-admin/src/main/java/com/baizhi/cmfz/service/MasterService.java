package com.baizhi.cmfz.service;

import java.util.Map;

public interface MasterService {

	public Map<String, Object> queryMaster(Integer nowPage, Integer pageSize);

	public Map<String, Object> queryMasterByName(Integer nowPage, Integer pageSize, String value);

	public boolean addMaster(String masterId, String masterName, Integer masterAge, String masterPhoto, String masterSummery);
	
	public boolean removeMaster(String masterId);
	
	public boolean modifyMaster(String masterId, String masterName, Integer masterAge, String masterPhoto, String masterSummery);

}
