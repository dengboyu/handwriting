package com.by.log.impl;


import com.by.log.Logger;

/**
 * @Author：by@Deng
 * @Date：2020/4/7 17:32
 */
public abstract class AbstractLogger implements Logger {

    private String name="defaultName";

    public AbstractLogger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void trace(String msg) {

    }

    public void debug(String msg) {

    }

    public void info(String msg) {

    }

    public void warn(String msg) {

    }

    public void error(String msg) {

    }
}
