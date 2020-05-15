package com.controller;

import com.entity.Employee;
import com.entity.Person;
import com.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2020-05-14 15:57:03
 */
/*@RestController*/
    @Controller
@RequestMapping("employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = {"list"})
    public String list(Model model){
        model.addAttribute("emplist",employeeService.queryAll());
        return "index";
    }

    @RequestMapping("detail")
    public String detail(Integer id,Model model){
        model.addAttribute("emp",employeeService.queryById(id));
        return "detail";
    }

    @RequestMapping("search")
    public String search(){
        System.out.println("按条件搜索");
        return "index";
    }
}