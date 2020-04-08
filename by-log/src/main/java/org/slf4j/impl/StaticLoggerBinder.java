package org.slf4j.impl;


import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * @Author：by@Deng
 * @Date：2020/4/8 9:44
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {

    public static String REQUESTED_API_VERSION = "1.7";

    public ILoggerFactory getLoggerFactory() {
        return null;
    }

    public String getLoggerFactoryClassStr() {
        return null;
    }

    public static Logger getSingleton(){
        return null;
    }
}
