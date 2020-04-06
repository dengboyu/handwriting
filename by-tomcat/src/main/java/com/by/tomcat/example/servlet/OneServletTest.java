package com.by.tomcat.example.servlet;

import com.by.tomcat.example.ByServlet;
import com.by.tomcat.example.ByServletRequest;
import com.by.tomcat.example.ByServletResponse;

/**
 * @author by@Deng
 * @create 2020-03-31 23:56
 */
public class OneServletTest extends ByServlet {

    public void doGet(ByServletRequest servletRequest, ByServletResponse servletResponse) throws Exception{
        this.doPost(servletRequest,servletResponse);
    }

    public void doPost(ByServletRequest servletRequest, ByServletResponse servletResponse) throws Exception{
        servletResponse.write("第一个servlet测试例子");
    }

}
