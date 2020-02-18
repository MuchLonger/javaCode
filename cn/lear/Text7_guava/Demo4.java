package cn.lear.Text7_guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;
import java.util.Set;

/**
 * @description: table类练习，table含有row（可以对应学生），column（课程），以及数据value（成绩）
 * @Time: 2018/8/13 16:09
 */
public class Demo4 {

    public static void main(String[] args) {
        Table<String, String, Integer> tables = HashBasedTable.create();
        //测试数据
        tables.put("cqy", "javaee", 90);
        tables.put("cqq", "javaee", 80);
        tables.put("cqy", "oracle", 70);
        tables.put("cqq", "oracle", 60);

        //查看所有行的数据
        Set<Table.Cell<String, String, Integer>> cells = tables.cellSet(); //返回的是cell类型
        for (Table.Cell<String, String, Integer> c :
                cells) {
            System.out.println(c.getRowKey() + "-->" + c.getColumnKey() + "-->" + c.getValue());
        }
        System.out.println("------------------按学生查看成绩------------------");
        System.out.print("学生\t");
        Set<String> cours = tables.columnKeySet();    //获取课程
        for (String t :
                cours) {
            System.out.print(t + "\t");
        }
        System.out.println();
        Set<String> stu = tables.rowKeySet();     //获取所有的学生
        for (String b :
                stu) {
            System.out.print(b + "\t");       //输出课程

            Map<String, Integer> scores = tables.row(b);      //获取每个学生除了row里面的属性的属性
            for (String c :
                    cours) {
                System.out.print(scores.get(c) + "\t");     //get方法返回value
            }

            System.out.println();
        }
        System.out.println("------------------按课程查看成绩------------------");
        System.out.print("课程\t");
        Set<String> stuSet = tables.rowKeySet();       //获取课程
        for (String t :
                stuSet) {
            System.out.print(t + "\t");       //输出学生
        }
        System.out.println();
        Set<String> cours1 = tables.columnKeySet();     //获取所有的学生
        for (String t :
                cours1) {
            System.out.print(t+"\t");

            Map<String,Integer> scores1=tables.column(t);      //获取每个学生除了column里面的属性的属性
            for (String c :
                    stuSet) {
                System.out.print(scores1.get(c)+"\t");      //get方法返回value
            }

        System.out.println();
    }
    }
}
