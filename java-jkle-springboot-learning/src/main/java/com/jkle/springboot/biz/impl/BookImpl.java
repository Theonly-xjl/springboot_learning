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
    public String save(BookEntity bookEntity) {

        BookEntity bookEntity1 = new BookEntity();
        bookEntity1.setBookId("5");
        bookEntity1.setBookName("红楼梦");
        bookMapper.insertSelective(bookEntity1);
        return "插入成功";
    }
}
