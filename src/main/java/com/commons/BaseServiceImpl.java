package com.commons;

import com.dao.EmployeeDao;
import com.dao.NoticeDao;
import com.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * Create by gc on 2020/5/19
 * 铁甲依然在
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    /*protected BaseDao baseDao;*/
    protected Mapper mapper;

    @Override
    public T queryById(Serializable id) {
        return (T) mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> queryAll(T t) {
        return mapper.select(t);
    }

    @Override
    public boolean insert(T t) {
        if(mapper.insert(t)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(T t) {
        if(mapper.updateByPrimaryKeySelective(t)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Serializable id) {
        if(mapper.deleteByPrimaryKey(id)>0){
            return true;
        }
        return false;
    }
}
