package cn.lear.Text9_Thread;

/**
 * @description:  Text1测试线程的各个方法,Text2测试优先级
 * @Time: 2018/8/16 16:24
 */
public class Demo7_ThreadIdea {

    public static void main(String[] args) throws InterruptedException {
        //Text1：线程方法

        /*
        Idea id=new Idea();
        Thread th=new Thread(id,"cqy");
        System.out.println(th.getName());
        System.out.println(Thread.currentThread().getName());

        th.start();
        System.out.println("启动后的状态"+th.isAlive());
        Thread.sleep(2);
        id.stop();
        Thread.sleep(200);      //暂停一下让cpu缓缓
        System.out.println("sleep后的状态"+th.isAlive());
        */

        //Text2：优先级
        Idea id1=new Idea();
        Thread t1=new Thread(id1,"cqy");
        Idea id2=new Idea();
        Thread t2=new Thread(id2,"cyy");

        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();


        Thread.sleep(100);

        id1.stop();
        id2.stop();

    }

}

class Idea implements Runnable {
    private boolean flag = true;
    private int num = 0;


    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "-->" + num++);
        }
    }

    public void stop() {
        this.flag = !this.flag;
    }
}