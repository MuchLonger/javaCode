package cn.lear.Text14_Javassist;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:    Demo2 javaassist练习
 * @Time: 2018/8/22 20:17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface cqq{
    String name();
    int year();

}
