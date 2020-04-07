package com.by.log;


/**
 * @Author：by@Deng
 * @Date：2020/4/7 19:02
 */
public interface LoggingEvent {

    String getThreadName();

    long getTimestamp();

    String getLoggerName();

    String getMessage();

}
