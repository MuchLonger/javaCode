package cn.lear.Text12_annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description: 使用反射读取注解的信息，并模拟处理注解信息的流程
 * @Time: 2018/8/21 17:33
 */
public class Demo4_refletion {


    public static void main(String[] args) {
        try {

            Class clazz = Class.forName("cn.lear.Text12_annotation.Demo3_1_ORM");   //利用反射

            Annotation[] annotations = clazz.getAnnotations();      //获取当前类的前面的注解
            for (Annotation temp :
                    annotations) {
                System.out.println(temp);

            }
            System.out.println("--------");
            //获得自定义类的指定的注解
            ORMAnnotation oa = (ORMAnnotation) clazz.getAnnotation(ORMAnnotation.class);    //获取当前类的指定注解
            System.out.println(oa.value());
            System.out.println("--------");

            //获得类的属性的注解
            Field f = clazz.getDeclaredField("sName");      //先获得注解修饰的那个属性
            ORMField of = f.getAnnotation(ORMField.class);  //再通过它获得注解的值
            System.out.println(of.columnName()+"--"+of.type()+"--"+of.length());

            //获取方法
            Method method=clazz.getDeclaredMethod("getAge");    //剩下的都一样
            ORMField of1=method.getAnnotation(ORMField.class);
            System.out.println(of1.columnName()+"--"+of1.type()+"--"+of1.length());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
