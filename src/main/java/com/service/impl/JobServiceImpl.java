package com.service.impl;

import com.commons.BaseServiceImpl;
import com.dao.DeptDao;
import com.entity.Job;
import com.dao.JobDao;
import com.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Job)表服务实现类
 *
 * @author makejava
 * @since 2020-05-18 11:26:48
 */
@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<Job> implements  JobService {
    @Autowired
    public void setMapper(JobDao jobDao){
        super.mapper = jobDao;
    }
}