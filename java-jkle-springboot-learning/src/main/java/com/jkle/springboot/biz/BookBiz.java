package com.jkle.springboot.biz;

import com.jkle.springboot.domain.BookEntity;

/**
 * @author: xujiale
 * @create: 2018/03/30
 * @description: 业务逻辑接口
 **/
public interface BookBiz {

    String save(BookEntity bookEntity) throws Exception;
}
