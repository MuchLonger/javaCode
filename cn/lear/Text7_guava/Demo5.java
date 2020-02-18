package cn.lear.Text7_guava;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import java.util.Iterator;

/**
 * @description: Bag
 * @Time: 2018/8/13 20:33
 */
public class Demo5 {
    public static void main(String[] args){
        Bag<String> bag=new HashBag<>();
        bag.add("c1");
        bag.add("a");
        bag.add("a",5);
        bag.add("c2");

        bag.remove("a",2);

        bag.add("b");
        bag.add("c3");

        Iterator<String> it=bag.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


    }



}
