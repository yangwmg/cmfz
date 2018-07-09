package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/8.
 */
@Repository
public interface LogDao {

    public boolean insertLog(Log log);

    public int count();

    public List<Log> selectAllLog(@Param("begin")Integer begin, @Param("end")Integer end);

}
