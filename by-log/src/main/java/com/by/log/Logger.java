package com.by.log;

/**
 * @author by@Deng
 * @create 2020-04-06 22:23
 */
public interface Logger {

    String getName();

    void trace(String msg);

    void debug(String msg);

    void info(String msg);

    void warn(String msg);

    void error(String msg);

}
