package cn.lear.Text13_Classtext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description: 反射方法的练习，获取属性，方法，构造器
 * @Time: 2018/8/21 21:40
 */
public class Demo2_reflection {

    public static void main(String[] args) {
        String path = "cn.lear.text.User";
        try {
            Class cl = Class.forName(path);       //第一步 先获取Class对象

            System.out.println("----------------------------");

            //获取类的名字
            System.out.println(cl.getName());   //获得包名
            System.out.println(cl.getSimpleName()); //获得类名

            System.out.println("----------------------------");

            //获取属性
            Field[] fields = cl.getFields();    //获得所有的public属性信息，并返回成数组,且只获取到属性的名称，并没有属性的数据
            Field[] allFields=cl.getDeclaredFields();   //获得所有的属性（无视访问权限）
            Field f=cl.getDeclaredField("Uname");       //获取单个属性的名称
            System.out.println(fields.length);
            System.out.println(allFields.length);
            System.out.println(f);

            for(Field fi:allFields){
                System.out.println(fi);     //只是属性的名称，权限，及类型
            }

            System.out.println("----------------------------");
            //获取方法的信息
            Method[]  methods=cl.getDeclaredMethods();      //同上，获取所有的方法信息
            Method  m1=cl.getDeclaredMethod("getId",null);
            Method  m2=cl.getDeclaredMethod("setId", int.class);        //后面的参数表示 方法内参数的类型，如果后面有参则必须传递参数类型对应的class，主要运用于方法的重载（参数不确定）

            for(Method me:methods){
                System.out.println(me);     //只是属性的名称，权限，及类型
            }

            System.out.println("----------------------------");

            //获取构造方法的信息
            Constructor[] constructors=cl.getDeclaredConstructors();    //获得所有的构造方法对象
            Constructor c=cl.getConstructor(int.class,int.class,String.class);      //通过传递参数的不同，获得不同的构造器
            for (Constructor co :
                    constructors) {
                System.out.println(co);
            }
            System.out.println(c);






        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
