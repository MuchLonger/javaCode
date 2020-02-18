package cn.lear.Text7_guava;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @description:    约束测试
 * @Time: 2018/8/13 15:57
 */
public class Demo3 {

    public static void main(String[] args){
        Set<String> sets= Sets.newHashSet();

        Constraint<String> constraint=new Constraint<String>() {
            @Override
            public String checkElement(String s) {
                //非空验证
                Preconditions.checkNotNull(s);
                //长度验证5-20位字符串
                Preconditions.checkArgument(s.length()>=5&&s.length()<=20);

                return s;
            }
        };

        Set<String> cs= Constraints.constrainedSet(sets,constraint);    //包装约束,形成新的Set

        cs.add(null);   //null,报错
        cs.add("good");     //长度不够，异常报错
        cs.add("dhiasdha");

        //差集
        Set<Integer> sets1= Sets.newHashSet(1,2,3,4,5,6);
        Set<Integer> sets2= Sets.newHashSet(3,4,5,6,7,8,9);
        Sets.SetView<Integer> diff=Sets.difference(sets1,sets2);        //sets1,sets2与sets2,sets1结果不一样。

        for (Integer temp :
                diff) {
            System.out.println(temp);
        }

    }
}
