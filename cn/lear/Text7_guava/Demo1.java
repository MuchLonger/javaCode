package cn.lear.Text7_guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:  guava只读测试
 * @Time: 2018/8/13 12:54
 */
public class Demo1 {
    public static void main(String[] args){

        List<String> list=new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        List<String> l= Collections.unmodifiableList(list);

        //l.add("r");

        List<String> immutableList= ImmutableList.of("a","b","c");

        immutableList.add("b");

        System.out.println(list.size());

    }
}
