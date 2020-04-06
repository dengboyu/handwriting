package com.by.tomcat.utils;



/**
 * @Author：by@Deng
 * @Date：2020/4/1 20:12
 */
public class CommonUtils {

    /**
     * Http协议返回
     *
     * @Author：by@Deng
     * @Date：2020/4/1 20:16
     */
    public static String HttpResponseFormatter(int httpCode,String content){

        int length = 0;
        if(null !=content) length = content.getBytes().length;

        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 ").append(httpCode);

        if(httpCode == 200){
            response.append(" OK\r\n");
        }else if(httpCode ==500){
            response.append(" Internal Error\r\n");
        }

        response.append("Content-Length: ").append(length).append("\r\n")
        .append("Content-Type: text/html; charset=utf-8\r\n")
        .append("\r\n")
        .append(content)
        .append("\r\n");

        return response.toString();
    }


}
