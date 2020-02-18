package cn.lear.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 容器练习
 * @Time: 2018/8/11 15:40
 */
public class Text02 {
    public static void main(String[] args){
        Map map=new HashMap();
        map.put("id",Integer.toOctalString(0301));     //自动转成了八进制，不知如何解决。
        map.put("name","cqy");
        map.put("salary",3500);
        map.put("department","项目部");
        map.put("hireDae","2007-10");


        Map map2=new HashMap();
        map2.put("id",0302);
        map2.put("name","cqq");
        map2.put("salary",3550);
        map2.put("department","项目部");
        map2.put("hireDae","2008-10");

        List<Map> list=new ArrayList<Map>();

        list.add(map);
        list.add(map2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get("id"));
        }

    }
}
