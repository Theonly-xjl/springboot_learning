package com.jkle.springboot.util;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: xujiale
 * @create: 2018/03/30
 * @description: 抛异常返回结果封装
 **/
@Accessors(chain = true)
@Data
public class ExceptionData {

    private Integer status;
    private String message;
    private StackTraceElement[] trace;

}
