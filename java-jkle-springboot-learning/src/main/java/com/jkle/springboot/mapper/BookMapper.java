package com.jkle.springboot.mapper;

import com.jkle.springboot.domain.BookEntity;
import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: xujiale
 * @create: 2018/03/30
 * @description: 数据库查询接口
 **/
@Repository
public interface BookMapper extends Mapper<BookEntity> {

}
