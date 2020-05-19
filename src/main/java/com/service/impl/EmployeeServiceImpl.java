package com.service.impl;

import com.commons.BaseServiceImpl;
import com.dao.NoticeDao;
import com.entity.Employee;
import com.dao.EmployeeDao;
import com.github.pagehelper.PageHelper;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 15:57:03
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    //需要给父类BaseServiceImpl的basedao赋值
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> queryAll(int pageNum, int pageSize, Employee employee) {
        PageHelper.startPage(pageNum,pageSize);
        return employeeDao.queryAll(employee);
    }

    @Override
    @Transactional
    public boolean batchDelet(Integer[] ids) throws Exception {
        int deleteCount = 0;
        for(Integer id:ids){
            int num = employeeDao.deleteById(id);
            deleteCount+=num;
        }
        if(deleteCount<ids.length){
            throw new Exception("删除失败！");
        }
        return true;
    }

    @Override
    public Employee queryById(Serializable id) {
        return employeeDao.queryById(id);
    }

    @Override
    public List<Employee> queryAll(Employee employee) {
        return employeeDao.queryAll(employee);
    }

    @Override
    public boolean insert(Employee employee) {
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteById(Serializable id) {
        return false;
    }
}