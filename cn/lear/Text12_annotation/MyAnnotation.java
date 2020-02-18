package cn.lear.Text12_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:    自定义注解
 * @Time: 2018/8/21 15:56
 */


@Target(value= ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String studentName();
    int age();
    int id() default -1;    //-1表示不存在
}
