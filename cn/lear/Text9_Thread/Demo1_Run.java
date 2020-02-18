package cn.lear.Text9_Thread;

/**
 * @description:    模拟龟兔赛跑
 * @Time: 2018/8/16 11:01
 */
public class Demo1_Run {

    public static void main(String[] args){
        //多线程练习
        Rabbit ra=new Rabbit();
        ra.start();

        Tortoise tor=new Tortoise();
        tor.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main-->"+i);
        }
    }

}
class Rabbit extends Thread{
    @Override
    public void run() {     //线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("兔子跑进了第"+i+"次");
        }
    }
}

class Tortoise extends Thread{
    @Override
    public void run() {     //线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("乌龟跑进了第"+i+"次");
        }
    }
}
