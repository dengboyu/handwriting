package com.by.tomcat.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 自定义tomcat
 *
 * @author by@Deng
 * @create 2020-03-31 23:33
 */
public class ByTomcatImpl implements ByTomcat {

    private int port;
    private ServerSocket serverSocket;
    private Map<String,ByServlet> servletMapping = new HashMap<>();
    private Properties webXml = new Properties();

    @Override
    public void init() throws IOException {
        //加载web.xml文件

        String basePath = this.getClass().getResource("/").getPath();
        FileInputStream fi = new FileInputStream(basePath + "web.properties");

        webXml.load(fi);

        //端口号
        port = Integer.parseInt(webXml.getProperty("port"));

        //初始化servletMapping
        for(Object k: webXml.keySet()){
            String key = k.toString();
            if(key.endsWith(".url")){

                String url = webXml.getProperty(key);

                String servletName = key.replaceAll("\\.url$","");
                String className = webXml.getProperty(servletName+".className");

                try {

                    ByServlet obj = (ByServlet) Class.forName(className).newInstance();

                    servletMapping.put(url,obj);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void startTomcat() throws IOException {

        init();

        serverSocket = new ServerSocket(port);


        while (true) {

            Socket socket = serverSocket.accept();  //阻塞

            process(socket);

        }
    }

    @Override
    public void process(Socket client) {

        InputStream is = null;
        OutputStream os = null;

        try {

            is = client.getInputStream();
            os = client.getOutputStream();

            ByServletRequest request = new ByServletRequest(is);
            ByServletResponse response = new ByServletResponse(os);

            /*int count = 0;
            while(count==0){
                count = is.available();
            }
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            System.out.println("客户端输入Http协议:" + new String(bytes, StandardCharsets.UTF_8));*/


            if(servletMapping.containsKey(request.getUrl())){

                servletMapping.get(request.getUrl()).service(request,response);

            }else{
                response.write("404 Not Find");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if(os!=null){
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if(client!=null){
                //关闭client: Http请求都是短连接
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
