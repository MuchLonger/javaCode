package cn.lear.Text18_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 正则表达式测试
 * @Time: 2018/8/27 11:00
 */
public class Demo1_regexText {
    public static void main(String[] args) {
        /*            表达式对象              */
        Pattern p = Pattern.compile("\\w+");

        Matcher m = p.matcher("cqyisvery++handsome123456");
        /*            这是将整个字符序列与表达式对象作匹配,一段一段的查找 ，遇到了++就结束了，              */
         boolean flag=m.matches();
        /*            一段一段的查找 ，比如上面遇到了++就结束了，下次就从handsome开始             */
          boolean flag2 = m.find();
        // System.out.println(flag);
        // boolean flag3 = m.find();
        // System.out.println(flag2);
        //System.out.println(flag3);

        /*System.out.println(m.find());
        System.out.println(m.group());
        System.out.println(m.find());
        System.out.println(m.group());*/
        /*            上面4个改良              */
        while(m.find()){
            System.out.println(m.group());
        }


    }

}
