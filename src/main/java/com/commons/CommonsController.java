package com.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共的controller,编写一些公共的方法
 * Create by gc on 2020/5/18
 * 铁甲依然在
 */
@Controller
public class CommonsController {

    //  nav/job/list
    @RequestMapping("nav/{dir}/{page}")
    public String nav(@PathVariable("dir") String dir,@PathVariable("page") String page){
        return dir+"/"+page;
    }


    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
