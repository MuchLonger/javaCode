package cn.lear.Text7_guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @description: 过滤器使用，类型转换,组合式函数式编程
 * @Time: 2018/8/13 14:12
 */
public class Demo2 {
    public static void main(String[] args) {
        /*   组合式函数式编程  */
        List<String> list = Lists.newArrayList("bcqyvfuy", "good", "dvawoyeiuveyhfwzde");

        Function<String, String> f1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.length() > 5 ? s.substring(0, 5) : s;
            }
        };

        Function<String, String> f2 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        Function<String,String> f= Functions.compose(f1,f2);

        Collection<String> resultCol=Collections2.transform(list,f);

        for (String temp :
                resultCol) {
            System.out.println(temp);
        }


    }

    /*       类型转化    */
    public static void changeFormat() {
        Set<Long> timeSet = Sets.newHashSet();

        timeSet.add(10000000000L);
        timeSet.add(88888888L);
        timeSet.add(511457857647L);

        /* 将长整型数转成时间格式的数 */
        Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long, String>() {

            @Override
            public String apply(Long aLong) {
                return new SimpleDateFormat("yyyy-MM-dd").format(aLong);
            }
        });

        for (String temp :
                timeStrCol) {
            System.out.println(temp);
        }
    }

    /* 过滤器 */
    public static void filter() {
        List<String> list = Lists.newArrayList("aba", "bab", "deg", "moon"); //一个静态对象

        Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {     //功能是筛选出正着和反着都一样的英文字母
            //业务判断
            @Override
            public boolean apply(String s) {

                return new StringBuilder(s).reverse().toString().equals(s);
            }
        });

        for (String temp :
                palindromeList) {
            System.out.println(temp);
        }

    }


}
