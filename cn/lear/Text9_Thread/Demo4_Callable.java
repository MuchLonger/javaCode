package cn.lear.Text9_Thread;

import java.util.concurrent.*;

/**
 * @description:    创建多线程的第三种方法（有返回值）
 * @Time: 2018/8/16 11:49
 */
public class Demo4_Callable {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建2个线程
        ExecutorService es= Executors.newFixedThreadPool(2);
        //获取对象值
        Race tor=new Race("乌龟",1000);
        Race rab=new Race("兔子",500);
        //获取值的方法，将乌龟和兔子对象传入到Future内进行操作
        Future<Integer> result1=es.submit(tor);
        Future<Integer> result2=es.submit(rab);
        //5s后停止
        Thread.sleep(5000);
        //这个setFlag是自己定义的，用来中断线程实现停止功能。（就是上面的while（flag））
        tor.setFlag(false);
        rab.setFlag(false);

        //实现类内方法，通过Future对象获取到重写的call方法返回的值
        int num1=result1.get();
        System.out.println("乌龟-->"+num1);   //返回一次当前时间内走的步数
        int num2=result2.get();
        System.out.println("兔子-->"+num2);
        //停止服务
        es.shutdownNow();

    }

}

//返回值类型为Integer
class Race implements Callable<Integer>{
    private String name;    //名称
    private long time;       //延时时间,建议使用long
    private boolean flag=true;  //
    private int step;       //步数

    public Race(String name) {
        this.name = name;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public Race() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public Integer call() throws Exception {
        while(flag){
            //延时,time是传入的值
            Thread.sleep(time);
            //示例是龟兔赛跑，所以每个time个时间步数就加一
            step++;
        }
        return step;
    }
}


