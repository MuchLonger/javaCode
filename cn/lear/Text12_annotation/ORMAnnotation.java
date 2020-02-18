package cn.lear.Text12_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:    ORM自定义注解，解析(如同table)
 * @Time: 2018/8/21 17:13
 */


@Target(value = {ElementType.TYPE})     //只能用在类里
@Retention(RetentionPolicy.RUNTIME)
public @interface ORMAnnotation {

String value();

}
