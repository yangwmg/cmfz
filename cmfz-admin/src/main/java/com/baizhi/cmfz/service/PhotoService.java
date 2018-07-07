package com.baizhi.cmfz.service;

import java.util.Map;

public interface PhotoService {

	public Map<String, Object> queryPhoto(Integer nowPage, Integer pageSize);

	public boolean addPhoto(String description, Integer status, String photoName);
	
	public boolean removePhoto(String photoId);
	
	public boolean modifyPhoto(String photoId, String description, Integer status, String photoName);

}
