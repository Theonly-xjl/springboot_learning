package com.jkle.springboot.exception;

/**
 * @author: xujiale
 * @create: 2018/03/30
 * @description:
 **/

public class ExceptionCode {

    private static int errorStatingCode = 1000;

    public static final int WAREHOUSE_DELETE_DEVICES_CODE = errorStatingCode++;
    public static final String WAREHOUSE_DELETE_DEVICES_MESSAGE = "Failed to delete the devices of warehouse %s.";

}

