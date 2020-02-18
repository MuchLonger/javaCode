package cn.lear.Text12_annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:    内置注解练习
 * @Time: 2018/8/21 15:41
 */
public class Demo1_Annotation {

    @Override       //重写
    public String toString() {
        return super.toString();
    }

    @Deprecated         //表示该类以及废弃，或不推荐使用
    public String cqy(){
        String dd = "dd";
        String dd1 = dd;
        return dd1;
    }

    @SuppressWarnings("all")        //用于删除当前方法所有的警告
    public static void test(){
        List list=new ArrayList();
        List list1=new ArrayList();
    }


    public static void main(String[] args){
        Date d=new Date();
        Demo1_Annotation da=new Demo1_Annotation();
        da.cqy();       //删除线
    }

}

