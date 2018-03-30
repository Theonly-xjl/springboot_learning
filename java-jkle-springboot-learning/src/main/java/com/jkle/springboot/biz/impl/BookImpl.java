package com.jkle.springboot.biz.impl;

import com.jkle.springboot.biz.BookBiz;
import com.jkle.springboot.domain.BookEntity;
import com.jkle.springboot.mapper.BookMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: xujiale
 * @create: 2018/03/30
 * @description: 业务逻辑实现类
 **/
@Service
public class BookImpl implements BookBiz{

    @Resource
    private BookMapper bookMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String bookadd() {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId("5");
        bookEntity.setBookName("红楼梦");
        bookMapper.insertSelective(bookEntity);
        return "插入成功";
    }
}
