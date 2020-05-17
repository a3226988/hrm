package com.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Employee)实体类
 *
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 944354951402978738L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 外键，关联部门表主键
    */
    private Integer deptId;
    private Dept dept;
    private Job job;
    private Integer jobId;
    
    private String name;
    
    private String cardid;
    
    private String address;
    
    private String postcode;
    
    private String tel;
    
    private String phone;
    
    private String qqnum;
    
    private String email;
    
    private Integer sex;
    private String sexStr;
    public String getSexStr(){
        if(sex==null){
            return "";
        }
        if(this.sex==1)
            return "男";
        else
            return "女";
    }
    
    private String party;
    
    private Object birthday;
    
    private String race;
    
    private String education;
    
    private String speciality;
    
    private String hobby;
    
    private String remark;

    private Date createdate;

}