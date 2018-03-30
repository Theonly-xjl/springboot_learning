package com.jkle.springboot.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author: xujiale
 * @create: 2018/03/30
 * @description:
 **/
public class MyException extends Exception {

    private static Log LOG = LogFactory.getLog(MyException.class);

    public MyException(String description, String detail) {
        super(description);
        LOG.error(detail);
    }
}
