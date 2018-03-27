package com.jkle.springboot.controller;

import com.jkle.springboot.domain.BookEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: xujiale
 * @create: 2018/03/27
 * @description:
 **/
@CrossOrigin //跨域请求
@RestController
@RequestMapping(value = "/book", produces = "application/json;charset=utf-8")
public class BookController {

    @RequestMapping(value = "/getBookName", method = RequestMethod.GET)
    public BookEntity getName() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId("1");
        bookEntity.setBookName("十万个为什么");
        return bookEntity;
    }

}
