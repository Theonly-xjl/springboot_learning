package com.jkle.springboot.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author: xujiale
 * @create: 2018/03/27
 * @description: 书实体类
 **/
@Accessors(chain = true)  //lombok 插件生成 getter() 和 setter()
@Data //注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@Entity                     //详见hibernate中@Entity和@Table的区别
@Table(name = "book")
public class BookEntity {

    @Id                         //详见hibernate中@Entity和@Table的区别
    @GeneratedValue             //@GeneratedValue注释定义了标识字段生成方式。
    @Column(name = "BOOK_ID", nullable = false)   //详见hibernate中@Entity和@Table的区别
    private String bookId;

    @Column(name = "BOOK_NAME")
    private String bookName;

}
