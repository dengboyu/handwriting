package com.by.log.impl;


/**
 * @Author：by@Deng
 * @Date：2020/4/7 18:11
 */
public class DefaultLogger extends AbstractLogger{

    DefaultLogger(String name) {
        super(name);
    }

    @Override
    public void debug(String msg) {
        System.err.println(msg);
    }

}
