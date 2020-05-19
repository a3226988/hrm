package com.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Create by gc on 2020/5/18
 * 铁甲依然在
 */
@Data
@Table(name = "notice")
public class Notice {
    @Id
    private Integer id;
    private String title;
    private String content;
    @Column(name = "createdate")
    private Date createDate;
    private Integer userId;
}
