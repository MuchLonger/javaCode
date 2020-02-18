package cn.lear.Text12_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @Time: 2018/8/21 17:18
 */

//ElementType.FIELD是指定属性能使用该注解，ElementType.METHOD是指定方法能使用该注解
@Target(value={ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ORMField {
    String columnName();
    String type();
    int length();
}


