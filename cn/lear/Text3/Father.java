package cn.lear.Text3;

/**
 * @description:    泛型父类练习
 * @Time: 2018/8/11 17:44
 */
public abstract class Father<T1,T2> {
    T1 age;
    public abstract  void test(T2 name);
}
class son1 extends  Father{
    @Override
    public void test(Object name) {

    }
}
class son<T> extends Father<Integer,String> {
    @Override
    public void test(String name) {
        System.out.println("111");
    }
}
class son2<T2> extends Father<Integer,T2> {
    @Override
    public void test(T2 name) {

    }
}
class son3<T1, T2> {
    public void test(T2 name) {

    }
}