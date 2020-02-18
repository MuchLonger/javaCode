package cn.lear.Text5;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 测试NewItems
 * @Time: 2018/8/12 16:16
 */
public class NewsItemApp {

    
    public static void main(String[] args){
        List<NewItems> list=new ArrayList<>();

        list.add(new NewItems("cqy",50,new Date(System.currentTimeMillis()-1000*60*60)));
        list.add(new NewItems("cqq",50,new Date(System.currentTimeMillis()-1000*60*60)));
        list.add(new NewItems("cyy",10,new Date()));


        System.out.println("排序前:\n"+list);

       // Collections.sort(list,NewItems::compareTo);
        System.out.println("排序后:\n"+list);

    }
}
