package com.jkle.springboot.controller;

import com.jkle.springboot.biz.BookBiz;
import com.jkle.springboot.domain.BookEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: xujiale
 * @create: 2018/03/27
 * @description:
 **/
@CrossOrigin //跨域请求
@RestController
@RequestMapping(value = "/book", produces = "application/json;charset=utf-8")
public class BookController {

    @Resource
    private BookBiz bookBiz;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(BookEntity bookEntity) throws Exception{
        return bookBiz.save(bookEntity);
    }

}
