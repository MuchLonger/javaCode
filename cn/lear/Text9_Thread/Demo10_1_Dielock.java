package cn.lear.Text9_Thread;

/**
 * @description: 死锁解决方案, 看电影示例,用信号灯法
 * @Time: 2018/8/16 22:04
 */

//功能是：不会说，run一下吧
//如果不用信号灯，会有bug，不明所以
public class Demo10_1_Dielock {
    public static void main(String[] args){
        Movie m=new Movie();

        Player p=new Player(m);
        Consumer c=new Consumer(m);

        new Thread(p).start();
        new Thread(c).start();
    }
}

//共同的资源，电影类
class Movie {
    private String pic;
    //信号灯法
    //flag -->T  A先开始，B等待，A结束后通知B
    //flag -->F  B开始，A等待，B结束后通知A
    private boolean flag=true;

    public synchronized void play(String pic) {
        if(!flag){  // A等
            try {
                this.wait();        //先暂停一下,释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic = pic;
        this.notify();      //唤醒当前
        this.flag=false;
    }

    public synchronized void watch() {
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pic);
        this.notifyAll();
        this.flag=true;
    }
}

//表演者类

class Player implements Runnable {
    private Movie m;

    public Player(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if ((i%2)==0) {
                m.play("猫和老鼠");
            } else {
                m.play("七龙珠");
            }
        }
    }
}

//消费者

class Consumer implements Runnable {
    private Movie m;

    public Consumer(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            m.watch();
        }
    }
}

