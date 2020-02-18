package cn.lear.Text17_Collection;

import java.util.HashMap;

/**
 * @description:
 * @Time: 2018/8/11 12:26
 */
public class MyHashSet {

    HashMap map;

    public static final Object PRESENT=new Object();

    public MyHashSet(){
        map=new HashMap();      //初始化一个map容器
    }

    public void add(Object obj){
        map.put(obj,PRESENT);       //set的不可重复就是利用了map里面键对象的不可重复
    }

    public int length(){
        return map.size();          //套用的是map模板所以用map的size()方法
    }

    public static void main(String[] args){
        MyHashSet set=new MyHashSet();
        set.add("ccc");
        set.add("ccc");
        set.add("ccc");
        System.out.println(set.length());
    }
}


