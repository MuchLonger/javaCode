package cn.lear.Text9_Thread;

/**
 * @description: 线程的同步练习
 * @Time: 2018/8/16 16:51
 */
public class Demo8_Synchronous {
    public static void main(String[] args) {

        Web12306 web = new Web12306();
        Thread th1 = new Thread(web, "甲");
        Thread th2 = new Thread(web, "乙");
        Thread th3 = new Thread(web, "丙");

        th1.start();
        th2.start();
        th3.start();
    }

}

class Web12306 implements Runnable {
    private int num = 50;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            text4();
        }
    }

    //线程不安全，，假设a b c都通过了if语句，就会有，a.num=1，b.num=1，c.num=1。a先进去num=0,这时候在b外部的形参（即最后一句sout里面的num已经变成0了）所以会显示异常
    public void text4() {
            if (num <= 0) {
                flag = false;
                return;
            }
        synchronized (this) {   // 里面只能放引用类型

            //模拟延时
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //模拟结束
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }


    //线程安全
    public void text3() {
        synchronized (this) {   // 里面只能放引用类型
            if (num <= 0) {
                flag = false;
                return;
            }
            //模拟延时
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //模拟结束
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }

    //线程安全
    public synchronized void text2() {
        if (num <= 0) {
            flag = false;
            return; //取消
        }
        //模拟延时
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟结束
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);

    }


    //线程不安全，会产生num=0的现象
    public void text1() {
        if (num <= 0) {
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟结束
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);

    }
}
