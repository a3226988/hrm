package com.dao;

import com.entity.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (Dept)表数据库访问层
 * 使用通用mapper插件，所有的dao接口只需要继承tk.mybatis.mapper.common.Mapper接口，即拥有单表的CRDU操作
 * 在继承的时候需要指定泛型，该泛型就是对应的表的实体类
 */
public interface DeptDao  extends Mapper<Dept> {

    @Select("select id from dept")
    List<Integer> getIds();

    List<String> getNames();
}