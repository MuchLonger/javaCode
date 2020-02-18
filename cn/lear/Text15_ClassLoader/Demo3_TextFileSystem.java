package cn.lear.Text15_ClassLoader;

/**
 * @description:    测试Demo2的类
 * @Time: 2018/8/23 0:00
 */
public class Demo3_TextFileSystem {

    public static void main(String[] args) throws ClassNotFoundException {
        Demo2_FileSystemClass fsc=new Demo2_FileSystemClass("d:/_java/src/src");
        Class<?> c=fsc.loadClass("src.com.company.myt");     // c输出为 class my
        Class<?> c2=fsc.loadClass("java.lang.String");     // c输出为 class my
        Class<?> c3=fsc.loadClass("my");     // c输出为 class my


        System.out.println(c.getClassLoader());
        System.out.println(c2.getClassLoader());        //返回空
        System.out.println(c2.getClass());
        System.out.println(c3.getClass());
        System.out.println(c3.getClassLoader());


        Demo3_TextFileSystem d3=new Demo3_TextFileSystem();
        d3.tt();

    }

    void text2(Car c){
c.run();
    }

    private int a=2;
    void tt(){
        Car c=new Car(){
          void run(){
              System.out.println("pao");
          }
        };
        c.run();
        text2(
                new Car(){
                void run(){
                    System.out.println("pkpao");
                }
                }
        );

    }


}
class Car{
    void run(){
        System.out.println("pk");
    }
}
