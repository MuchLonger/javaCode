package cn.lear.Text16_GOF;

import java.util.Date;

/**
 * @description:    浅复制，会随着父亲的值改变而改变（本质上是复制引用位置）。深复制，不会随着父亲的值改变而改变（本质是新建了一个新的与之前一模一样的对象）
 * @Time: 2018/8/24 16:50
 */
public class Demo2_2_Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date=new Date(27894179421L);
        Demo2_1_DeepClone deep=new Demo2_1_DeepClone("cqy",date);
        Demo2_1_DeepClone deepClone=(Demo2_1_DeepClone)deep.clone();


        System.out.println(deep);
        System.out.println(deep.getBirthday());
        System.out.println(deep.getSname());

        date.setTime(254871648492L);

        System.out.println(deep.getBirthday());

        System.out.println("------------------------");

        deepClone.setSname("cyy");
        System.out.println(deepClone);
        System.out.println(deepClone.getBirthday());
        System.out.println(deepClone.getSname());

    }


}
