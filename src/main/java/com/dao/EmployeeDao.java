package com.dao;

import com.commons.BaseDao;
import com.entity.Employee;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Employee)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-14 15:57:02
 */
public interface EmployeeDao extends BaseDao<Employee> {
    //自由添加子接口特有的方法
}