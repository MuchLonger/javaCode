package cn.lear.Text15_ClassLoader;

/**
 * @description:    Loader测试
 * @Time: 2018/8/22 21:53
 */
public class Demo1_Loader {
    public static void main(String[] args){
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent()); //利用组合来实现的 伪“继承”关系
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println(System.getProperty("java.class.path"));

    }

}
