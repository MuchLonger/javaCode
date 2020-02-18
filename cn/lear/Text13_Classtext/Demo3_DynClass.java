package cn.lear.Text13_Classtext;

import cn.lear.text.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 通过反射动态的操作：构造器，方法，属性
 * @Time: 2018/8/21 22:06
 */
public class Demo3_DynClass {
    public static void main(String[] args) {
        String path = "cn.lear.text.User";
        try {
            Class<User> cl = (Class<User>)Class.forName(path);  //利用泛型强转属性的类型，方便后面的使用

            //利用反射动态的调用构造方法
            User u =  cl.newInstance();         //确保无参构造器的存在，否则会报InstantiationExcetion异常


            Constructor<User> c=cl.getConstructor(int.class,int.class,String.class);    //使用泛型

            User u2=  c.newInstance(1001,18,"cqy");     //利用newInstance方法获得构造方法并将值传入（指定的构造方法）

            System.out.println(u2.getName());

            //利用反射动态的调用普通方法
            System.out.println("----------------------------");
            User u3=cl.newInstance();   //同上
            Method method=cl.getDeclaredMethod("setName", String.class);    //调用setName方法
            method.setAccessible(true);      // 忽视访问权限，直接访问里面的数据，Field内也有这个属性

            method.invoke(u3,"cqy2");       //功能类似与u3.setName("cqy2"); 意思是都是通过属性来更改这些属性了，以后就可以通过数据库等方式，得到要更改的属性的名称及要更改的数据，这样就能实现不用手动输入而借助数据库来输入。
            System.out.println(u3.getName());

            //利用反射动态的调用属性
            System.out.println("----------------------------");
            User u4=cl.newInstance();   //同上
            Field f=cl.getDeclaredField("name");        //获取name属性的节点

            f.setAccessible(true);      // 忽视访问权限，直接访问里面的数据，Method内也有这个属性,如果没有会报错
            f.set(u4,"cqy3");       //利用l.getDeclaredField获取Field对象f， 再用f内的set方法加上User的对象和要设置的值更改属性内容。

            System.out.println(f.get(u4));  //通过反射调用



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


}
