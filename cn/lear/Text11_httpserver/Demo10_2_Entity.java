package cn.lear.Text11_httpserver;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:    用于存储web.xml内的标签servlet内的内容
 * @Time: 2018/8/20 23:24
 */
public class Demo10_2_Entity {
    private String name;       //存储servle-name
    private String slc;     //存储servlet-class

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlc() {

        Map map=new HashMap();
        return slc;
    }

    public void setSlc(String slc) {
        this.slc = slc;
    }

    public Demo10_2_Entity(String name, String slc) {
        this.name = name;
        this.slc = slc;
    }

    public Demo10_2_Entity() {
    }
}
