package cn.lear.Text11_httpserver;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:    储存Servlet的源文件
 * @Time: 2018/8/19 17:00
 */
public class Demo6_ServletContent {

    /*下面是旧版

    //参数1是别名，参数2是Servlet对象
    private Map<String,Demo4_Servlet> servlet;
    //参数1是url，参数2是别名（这个别名就是上面的别名）
    private Map<String,String> mapping;
    */
    //这是新版，存储对象的方式
    //存储servlet
    private Map<String,String> servlet;
    //存储mapping
    private Map<String,String> mapping;



    public Demo6_ServletContent() {
        servlet=new HashMap<>();
        mapping=new HashMap<>();

    }

    public Map<String, String> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, String> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
