package cn.lear.Text18_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 替换的使用
 * @Time: 2018/8/27 11:22
 */
public class Demo3_Replace {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[0-9]");

        Matcher m = p.matcher("cqyisvery++hands23%%ome123456");

        //替换的使用，只是生成新字符串，不会改变原来的
        String newStr = m.replaceAll("-");
        System.out.println(newStr);


    }


}
