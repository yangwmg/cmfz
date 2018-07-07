package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PhotoDao;
import com.baizhi.cmfz.entity.Photo;
import com.baizhi.cmfz.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/4.
 */
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoDao pd;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public Map<String, Object> queryPhoto(Integer nowPage, Integer pageSize) {

        List<Photo> photos = pd.selectAllPhoto((nowPage-1)*pageSize, nowPage*pageSize-1);

        int count = pd.count();

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("total", count);
        map.put("rows", photos);

        return map;
    }

    @Override
    public boolean addPhoto(String description, Integer status, String photoName) {

        Photo photo = new Photo();

        photo.setPhotoName(photoName);
        photo.setDescription(description);
        photo.setStatus(status);
        photo.setUploadTime(new Date());

        int result = pd.insertPhoto(photo);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean removePhoto(String photoId) {

        int result = pd.deletePhoto(photoId);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyPhoto(String photoId, String description, Integer status, String photoName) {

        Photo photo = pd.selectPhoto(photoId);

        photo.setPhotoName(photoName);
        photo.setDescription(description);
        photo.setStatus(status);

        int result = pd.updatePhoto(photo);

        if(result != 0){
            return true;
        }
        return false;
    }

}
