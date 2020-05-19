package com.service.impl;

import com.commons.BaseDao;
import com.commons.BaseServiceImpl;
import com.dao.NoticeDao;
import com.entity.Notice;
import com.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Create by gc on 2020/5/19
 * 铁甲依然在
 */
@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService {

    //需要给父类BaseServiceImpl的basedao赋值
    @Autowired
    public void setBaseDao(NoticeDao noticeDao){
        super.mapper = noticeDao;
    }


}
