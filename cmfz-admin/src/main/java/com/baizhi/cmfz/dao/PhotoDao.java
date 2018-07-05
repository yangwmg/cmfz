package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.Photo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Repository
public interface PhotoDao {

    public int insertPhoto(Photo photo);

    public int deletePhoto(String photoId);

    public int updatePhoto(Photo photo);

    public int count();

    public List<Photo> selectAllPhoto(@Param("begin")Integer begin, @Param("end")Integer end);
}
