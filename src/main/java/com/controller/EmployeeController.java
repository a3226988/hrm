package com.controller;

import com.entity.Dept;
import com.entity.Employee;
import com.entity.Job;
import com.github.pagehelper.PageInfo;
import com.service.DeptService;
import com.service.EmployeeService;
import com.service.JobService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2020-05-14 15:57:03
 */
/*@RestController*/
@Controller
@RequestMapping("employee")
@RequiresRoles("personnel")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = {"list"})
    public String list(Model model,@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                       @RequestParam(required = false,defaultValue = "2")Integer pageSize,Employee employee){
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeService.queryAll(pageNum,pageSize,employee));
        model.addAttribute("pageInfo",pageInfo);
        return "emp/list";
    }

    @RequestMapping("batchdelete")
    public void batchDelete(Integer[] ids, HttpServletResponse response) {
        try {
            employeeService.batchDelet(ids);
            response.getWriter().print("<script>location.href='/employee/list'</script>");
        } catch (Exception e) {
            e.printStackTrace();
            //如果要给出提示
            //1、将提示信息存入作用域，再跳转到页面中通过js显示
            //2、通过响应js代码实现提示信息并跳转页面
            System.out.println("删除失败");
            //return "redirect:/employee/list";
            try {
                response.getWriter().print("<script>alert('删除出错！');location.href='/employee/list'</script>");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RequestMapping("detail")
    public String detail(Integer id,Model model){
        model.addAttribute("emp",employeeService.queryById(id));
        return "emp/detail";
    }

    @RequestMapping("search")
    public String search(){
        System.out.println("按条件搜索");
        return "index";
    }

    @Autowired
    DeptService deptService;

    @Autowired
    JobService jobService;

    @ModelAttribute("depts")
    public void getDepts(HttpSession session){
        List<Dept> depts = (List<Dept>) session.getAttribute("depts");
        if(depts==null){
            depts = deptService.queryAll(new Dept());
            session.setAttribute("depts",depts);
        }
    }

    @ModelAttribute("jobs")
    public void getJobs(HttpSession session){
        List<Job> jobs = (List<Job>) session.getAttribute("jobs");
        if(jobs==null){
            jobs = jobService.queryAll(new Job());
            session.setAttribute("jobs",jobs);
        }
    }

}