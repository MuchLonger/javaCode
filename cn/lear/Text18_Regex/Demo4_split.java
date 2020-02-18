package cn.lear.Text18_Regex;

import java.util.Arrays;

/**
 * @description: 分割的使用
 * @Time: 2018/8/27 11:24
 */
public class Demo4_split {
    public static void main(String[] args) {

        String str = ("cqyisvery++hands23%%ome123456");

        String[] arr=str.split("\\d+");     //正则表达式在字符串内的应用

        System.out.println(Arrays.toString(arr));


    }


}
