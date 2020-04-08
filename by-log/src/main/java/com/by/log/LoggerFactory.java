package com.by.log;


import com.by.log.impl.DefaultLoggerFactory;

/**
 * @Author：by@Deng
 * @Date：2020/4/7 18:08
 */
public class LoggerFactory {

    private LoggerFactory() {
    }


    public static Logger getLogger(String name){
        return DefaultLoggerFactory.getInstance().getLogger(name);
    }

}
