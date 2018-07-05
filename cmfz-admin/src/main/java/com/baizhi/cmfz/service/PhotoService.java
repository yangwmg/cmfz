package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Photo;

import java.util.Map;

public interface PhotoService {

	public Map<String, Object> queryPhoto(Integer nowPage, Integer pageSize);

	public boolean addPhoto(Photo photo);
	
	public boolean removePhoto(String photoId);
	
	public boolean modifyPhoto(Photo photo);

}
