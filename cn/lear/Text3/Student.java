package cn.lear.Text3;

import java.util.List;

/**
 * @description:    泛型练习，学生类
 * @Time: 2018/8/11 17:23
 */
public class Student<T> {
    private T javase;

    public Student(T javase) {
        this.javase = javase;
    }

    public Student() {
    }

    public T getJavase() {
        return javase;
    }

    public static <T extends List> void test(){

    }

    public void setJavase(T javase) {
        this.javase = javase;
    }
}

interface Comparator<T>{
    public static final int MAX_VALUE=1024;
    void compare(T t);

}

