package com.by.log.impl;


import com.by.log.ILoggerFactory;
import com.by.log.Logger;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author：by@Deng
 * @Date：2020/4/7 9:29
 */
public class DefaultLoggerFactory implements ILoggerFactory {

    private DefaultLoggerFactory() {
    }

    private static DefaultLoggerFactory singleton = null;
    private static volatile ConcurrentHashMap<String, Logger> loggerFactory = new ConcurrentHashMap();

    public static DefaultLoggerFactory getInstance(){

        if(singleton==null){
            synchronized (DefaultLoggerFactory.class){
                if (singleton==null) {
                    singleton = new DefaultLoggerFactory();
                }
            }
        }
        return singleton;
    }


    public Logger getLogger(String name) {

        Logger logger = loggerFactory.get(name);
        if (logger == null) {

            synchronized (DefaultLoggerFactory.class) {

                logger = loggerFactory.get(name);
                if (logger == null) {

                    logger = new DefaultLogger(name);

                    loggerFactory.putIfAbsent(name, logger);
                }
            }
        }

        return logger;
    }
}
