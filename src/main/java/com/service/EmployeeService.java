package com.service;

import com.commons.BaseService;
import com.entity.Employee;
import java.util.List;

/**
 * (Employee)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 15:57:02
 */
public interface EmployeeService extends BaseService<Employee> {

    List<Employee> queryAll(int pageNum,int pageSize,Employee employee);

    /**
     * 批量删除
     * @return
     */
    boolean batchDelet(Integer[] ids) throws Exception;
}