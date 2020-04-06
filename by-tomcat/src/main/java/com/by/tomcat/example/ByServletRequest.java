package com.by.tomcat.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author by@Deng
 * @create 2020-04-01 00:16
 */
public class ByServletRequest {

    private InputStream is;
    private String url;
    private String method;

    public ByServletRequest(InputStream is) {
        init(is);
    }


    private void init(InputStream is){

        this.is = is;

        try {

            byte[] bytes = new byte[1024];

            int len = 0;
            String content = "";    //http字符串协议

            if((len = is.read(bytes))>0){
                content = new String(bytes,0,len);
            }

            String line = content.split("\\n")[0];
            String[] arr = line.split("\\s");

            this.method = arr[0];
            if(arr.length>1){
                this.url = arr[1].split("\\?")[0];
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMethod(){
        return this.method;
    }

    public String getUrl(){
        return this.url;
    }

    public Map<String,String> getParameterMap(){
        return null;
    }
}
