package cn.lear.Text18_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:    测试正则表达式的分组处理
 * @Time: 2018/8/27 11:16
 */
public class Demo2_regexGroup {
    public static void main(String[] args){
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");

        Matcher m = p.matcher("cqyisvery++hands23%%ome123456");

        //分组的使用
        while(m.find()){
            System.out.print(m.group()+"-");
            System.out.print(m.group(1)+"-");     //表示的是[a-z]+的内容
            System.out.println(m.group(2));     //表示的是[0-9]+的内容
            System.out.println("----------------");
        }


    }

}
