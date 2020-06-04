package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试分页
 * Create by gc on 2020/5/27
 * 铁甲依然在
 */
@RestController
@RequestMapping("page")
public class PageTestController {


    @RequestMapping
    public void pages(Integer pageNum,Integer pageSize){
        System.out.println("pageNum:"+pageNum);
        System.out.println("pageSize:"+pageSize);
    }
}
