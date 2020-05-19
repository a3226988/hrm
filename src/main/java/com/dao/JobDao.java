package com.dao;

import com.entity.Job;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (Job)表数据库访问层
 */
public interface JobDao extends Mapper<Job> {


}