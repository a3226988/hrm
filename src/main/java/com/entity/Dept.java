package com.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (Dept)实体类
 *
 */
@Data
public class Dept implements Serializable {
    private static final long serialVersionUID = -19580316498113360L;
    private Integer id;
    private String name;
    private String remark;
    private int uId;
}