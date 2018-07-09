package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/8.
 */
@Repository
public interface UserDao {

    public List<User> selectAllUser();

}
