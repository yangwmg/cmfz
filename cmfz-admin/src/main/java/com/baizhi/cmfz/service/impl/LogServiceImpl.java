package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/4.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao ld;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public Map<String, Object> queryLog(Integer nowPage, Integer pageSize) {

        List<Log> logs = ld.selectAllLog((nowPage-1)*pageSize, nowPage*pageSize-1);

        int count = ld.count();

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("total", count);
        map.put("rows", logs);

        return map;
    }

}
