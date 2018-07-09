package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Repository
public interface MasterDao {

    public int insertMaster(Master master);

    public int insertMasters(@Param("masters") List<Master> masters);

    public int deleteMaster(String masterId);

    public int updateMaster(Master master);

    public int count();

    public int countByName(@Param("value")String value);

    public Master selectMaster(String masterId);

    public List<Master> selectMasterByName(@Param("begin") Integer begin, @Param("end") Integer end, @Param("value")String value);

    public List<Master> selectAllMaster1(@Param("begin") Integer begin, @Param("end") Integer end);

    public List<Master> selectAllMaster2();

    public List<Master> selectAllMaster3();
}
