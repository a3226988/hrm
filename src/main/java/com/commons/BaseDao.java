package com.commons;

import com.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * 所有dao层的通用接口，定义共有的方法
 * Create by gc on 2020/5/19
 */
public interface BaseDao<T> {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    T queryById(Serializable id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<T> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param t 实例对象
     * @return 对象列表
     */
    List<T> queryAll(T t);

    /**
     * 新增数据
     *
     * @param t 实例对象
     * @return 影响行数
     */
    int insert(T t);

    /**
     * 修改数据
     *
     * @param t 实例对象
     * @return 影响行数
     */
    int update(T t);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Serializable id);

}
