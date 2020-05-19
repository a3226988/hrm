package com.commons;

import com.entity.Dept;

import java.io.Serializable;
import java.util.List;

/**
 * 通用业务层
 * Create by gc on 2020/5/18
 * 铁甲依然在
 */
public interface BaseService<T> {

    /**
     * 通过ID查询单条数据
     */
    T queryById(Serializable id);

    /**
     * 查询条件所有数据
     * @return
     */
    List<T> queryAll(T t);
    /**
     * 新增数据
     * @param t 实例对象
     * @return 实例对象
     */
    boolean insert(T t);

    /**
     * 修改数据
     * @param t 实例对象
     * @return 实例对象
     */
    boolean update(T t);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Serializable id);
}
