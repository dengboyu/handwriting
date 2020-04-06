package com.by.tomcat.example;

import java.io.IOException;
import java.net.Socket;

/**
 * @author by@Deng
 * @create 2020-03-31 23:36
 */
public interface ByTomcat {

    void init() throws IOException;

    void startTomcat() throws IOException;

    void process(Socket client);


}
