package com.service.impl;

import com.commons.BaseServiceImpl;
import com.entity.Dept;
import com.dao.DeptDao;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Dept)表服务实现类
 *
 * @author makejava
 * @since 2020-05-18 11:26:48
 */
@Service("deptService")
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    @Autowired
    public void setMapper(DeptDao deptDao){
        super.mapper = deptDao;
    }
}