package com.by.tomcat.example;


/**
 * @author by@Deng
 * @create 2020-03-31 23:42
 */
public abstract class ByServlet {

    public void service(ByServletRequest servletRequest,ByServletResponse servletResponse) throws Exception{

        if("Get".equalsIgnoreCase(servletRequest.getMethod())){
            doGet(servletRequest,servletResponse);
        } else {
            doPost(servletRequest,servletResponse);
        }
    }

    public abstract void doGet(ByServletRequest servletRequest,ByServletResponse servletResponse) throws Exception;

    public abstract void doPost(ByServletRequest servletRequest,ByServletResponse servletResponse) throws Exception;

}
