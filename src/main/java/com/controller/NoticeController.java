package com.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by gc on 2020/5/21
 * 铁甲依然在
 */
@RestController
@RequestMapping("notice")
public class NoticeController {

    @RequestMapping("add")
    @RequiresPermissions("notice:add")
    public void add(){
        System.out.println("notice:add");
    }

    @RequestMapping("view")
    @RequiresPermissions("notice:view")
    public void view(){
        System.out.println("notice:view");
    }
}
