package cn.lear.Text9_Thread;

/**
 * @description: 单例模式创建的第二种方法：饿汉式
 * @Time: 2018/8/16 18:24
 */
public class Demo9_1_Danli2 {

}

//单例模式创建之饿汉式
class MyJvm{
    private static MyJvm instance=new MyJvm();  //一开始就创建好，且不执行两次，线程安全。
    private MyJvm(){}
    public static MyJvm getInstance(){
        return instance;
    }

}

//单例模式创建之饿汉式改良，通过它可以延缓加载时间（不调用的时候不加载）。原理：类在被调用时才会加载里面的内容。
class MyJvm2{
    private static class Jvmholder {
        private static MyJvm2 instance = new MyJvm2();  //一开始就创建好，且不执行两次，线程安全。
    }
    private MyJvm2(){}
    public static MyJvm2 getInstance(){
        return Jvmholder.instance;
    }

}