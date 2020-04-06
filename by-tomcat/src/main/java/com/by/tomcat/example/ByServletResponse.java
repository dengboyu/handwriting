package com.by.tomcat.example;

import com.by.tomcat.utils.CommonUtils;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author by@Deng
 * @create 2020-04-01 00:16
 */
public class ByServletResponse {

    private OutputStream os;

    public ByServletResponse(OutputStream os) {
        this.os = os;
    }

    public void write(String outString) throws Exception{
        os.write(CommonUtils.HttpResponseFormatter(200,outString).getBytes(StandardCharsets.UTF_8));
    }
}
