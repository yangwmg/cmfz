package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
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
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao md;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public Map<String, Object> queryMaster(Integer nowPage, Integer pageSize) {

        List<Master> masters = md.selectAllMaster1((nowPage-1)*pageSize, nowPage*pageSize-1);

        int count = md.count();

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("total", count);
        map.put("rows", masters);

        return map;
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public List<Master> queryMaster() {

        List<Master> masters = md.selectAllMaster2();

        return masters;
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public List<Master> queryMaster2() {

        List<Master> masters = md.selectAllMaster3();

        return masters;
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
    public Map<String, Object> queryMasterByName(Integer nowPage, Integer pageSize, String value) {

        String v = "%"+value+"%";

        List<Master> masters = md.selectMasterByName((nowPage-1)*pageSize, nowPage*pageSize-1, v);

        int count = md.countByName(v);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("total", count);
        map.put("rows", masters);

        return map;
    }

    @Override
    public boolean addMaster(String masterId, String masterName, Integer masterAge, String masterPhoto, String masterSummery) {

        Master master = new Master(masterId, masterName, masterAge, masterPhoto, masterSummery);

        int result = md.insertMaster(master);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addMasters(List<Master> masters) {

        int result = md.insertMasters(masters);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMaster(String masterId) {

        int result = md.deleteMaster(masterId);

        if(result != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyMaster(String masterId, String masterName, Integer masterAge, String masterPhoto, String masterSummery) {

        Master master = new Master(masterId, masterName, masterAge, masterPhoto, masterSummery);

        int result = md.updateMaster(master);

        if(result != 0){
            return true;
        }
        return false;
    }

}
