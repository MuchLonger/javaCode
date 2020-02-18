package cn.lear.Text11_httpserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:    用于存储web.xml内的标签servlet-mapping内的内容
 * @Time: 2018/8/20 23:26
 */
public class Demo10_3_Mapping {
    private String name;            //用于存储name值
    private List<String> urlPattern;         //存储url-pattern的值。因为存在一对多的关系，所以用容器存储


    public Demo10_3_Mapping() {
        urlPattern=new ArrayList<>();  //初始化

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(List<String> urlPattern) {
        this.urlPattern = urlPattern;
    }

    public Demo10_3_Mapping(String name, List<String> urlPattern) {
        this.name = name;
        this.urlPattern = urlPattern;
    }

}
