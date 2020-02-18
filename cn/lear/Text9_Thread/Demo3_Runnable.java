package cn.lear.Text9_Thread;

/**
 * @description:    使用静态代理加Runnable实现多线程
 * @Time: 2018/8/16 11:30
 */
public class Demo3_Runnable {


    public static void main(String[] args){
//        //创建真实角色
//        Programmer pro=new Programmer();
//        //再创建代理角色并在代理角色里添加对真实角色的引用
//        Thread proxy=new Thread(pro);
//        //调用.start()启动线程
//        proxy.start();


        Web123 web=new Web123();
        Thread th1=new Thread(web,"甲");
        Thread th2=new Thread(web,"乙");
        Thread th3=new Thread(web,"丙");


        th1.start();
        th2.start();
        th3.start();

//        for (int i = 0; i < 100; i++) {
//            System.out.println("main路径"+i);
//        }
    }
}

//这是真实角色类
class Programmer implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("真实角色-->"+i);
        }
    }

}
class Web123 implements Runnable{
    private int num=50;

    @Override
    public void run() {
        while(true){
            if(num<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //模拟结束
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }
    }
}
