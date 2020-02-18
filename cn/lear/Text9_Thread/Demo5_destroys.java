package cn.lear.Text9_Thread;

/**
 * @description: Join练习
 * @Time: 2018/8/16 12:25
 */
public class Demo5_destroys extends Thread{

    public static void main(String[] args) throws InterruptedException {
        Demo5_destroys demo=new Demo5_destroys();
        Thread t=new Thread(demo);  //新生
        t.start();      //就绪


        // 效果：先执行main，当i为50的时候执行t.start，而后再执行
        for (int i = 0; i < 200; i++) {
            if (i %20==0) {
//                t.join();       //这句话让main阻塞
                Thread.yield();
            }
            System.out.println("main...."+i);
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("join...."+i);
        }
    }
}
