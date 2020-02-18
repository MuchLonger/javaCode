package cn.lear.Text6;

import cn.lear.Text3.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 测试垃圾回收机制
 * @Time: 18-8-13 上午11:01
 */
public class Demo {
    public static void main(String[] args){
        //WeakHashMap<String,String> map=new WeakHashMap<>();
        Student<?> s=new Student<Integer>();
//        s.setJavase("");
        System.out.println(s.getJavase());
        Map<String,String> map=new HashMap<>();

        map.put("abc","d");
        map.put("ab","k");
        map.put(new String("d"),"c");
        map.put(new String("r"),"c");

        System.gc();
        System.runFinalization();

        System.out.println(map.size());

    }
}