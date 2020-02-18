package cn.lear.Text9_Thread;

/**
 * @description:  死锁
 * @Time: 2018/8/16 20:30
 */

public class Demo10_Dielock {


    public static void main(String[] args){
        Object g=new Object();
        Object m=new Object();

        Test t1=new Test();
        //Test2 t2=new Test2(g,m);

        Thread proxy=new Thread(t1);
        //Thread proxy2=new Thread(t2);

        proxy.start();
       // proxy2.start();


    }

}

class Test implements  Runnable{
   Object goods;//=new Object();
    Object money=new Object();

//    public Test(Object goods, Object money) {
//        this.goods = goods;
//        this.money = money;
//    }

    @Override
    public void run() {
        while(true){
            test();
        }
    }

    public void test(){
        synchronized (goods){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cqq");
//            synchronized (money){
//                System.out.println("cqy");
//            }
        }
        System.out.println("钱");
    }
}

class Test2 implements Runnable{
    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    Object goods;
    Object money;

    @Override
    public void run() {
        while(true){
            test();
        }
    }

    public void test(){
        synchronized (money){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods){

            }
        }
        System.out.println("货");
    }
}
