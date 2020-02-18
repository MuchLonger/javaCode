package cn.lear.text1;


import java.util.*;

/**
 * @description: 迭代器练习
 * @Time: 2018/8/11 16:00
 */
public class Text01 {


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        Set set=new HashSet();
        int i=new Integer(128).intValue();

        set.add("cq");
        set.add("cy");
        set.add("cqy");

        Iterator iter=set.iterator();

        while(iter.hasNext()){
            String str=(String) iter.next();
            System.out.println(str);
        }

        for(Iterator iter1=set.iterator();iter.hasNext();){
            String str1=(String) iter.next();
            System.out.println(str1);
        }
        Map map=new HashMap();

        map.put("1","fff");
        map.put("2","ttt");

        Set keys=map.keySet(); //keySet方法返回一个只有key的Set容器


        for (Iterator iter1=keys.iterator();iter1.hasNext();){
            String keyStr=(String)iter.next();
            System.out.println(keyStr);
        }



    }
}
