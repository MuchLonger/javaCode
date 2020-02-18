package cn.lear.Text9_Thread;

/**
 * @description: 单例设计模式： 作用是确保一个类只有一个对象,
 * @Time: 2018/8/16 17:41
 */
public class Demo9_Danlisheji {


    public static void main(String[] args) {
        JvmThread thread1=new JvmThread(100);
        JvmThread thread2=new JvmThread(100);
        thread1.start();
        thread2.start();

    }
}

class JvmThread extends Thread {
    private long time;

    public JvmThread() {

    }

    public JvmThread(long time) {
        this.time = time;

    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Jvm.getInstance2(time));
    }
}

//单例设计模式之懒汉式，注意点：双重检查（double checked)
class Jvm {
    //声明一个私有的静态变量
    private static Jvm instance = null;

    //现将构造器私有化，
    private Jvm() {

    }

    //一个对外引用的静态方法,synchronize很关键，这解决了多线程时内存不同步的问题
    public  static synchronized Jvm getInstance(long time) {
        if (instance == null) {
            //会产生多线程不同步的原因： 同时有两个线程进入到if条件语句里面，并new了两个不同的对象。
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Jvm();
        }
        return instance;
    }


    public  static  Jvm getInstance2(long time) {
        //使用Jvm.class来锁定，因为是static方法，没有this指针。ps：补充一点，我的认为是synchronize(this){}，的意思是拦住this指针，而对其他对象无影响，不知是否正确。
        synchronized (Jvm.class) {      //有弊端，当存在了对象之后还要等，下面解决
            if (instance == null) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Jvm();
            }
        }
            return instance;
    }
    public  static  Jvm getInstance3(long time) {   //可以提高已经存在对象的效率
        //下面这句用于提高效率
        if(instance==null) {        //既然存在了对象也要等，那就先判断一次不就行了。(ps:（这是我一开始的想法）一开始我的想法是先判断，这样下面判断语句里面省了再判断一次了（太天真））
            synchronized (Jvm.class) {
                //这句是用来确保安全的
                if (instance == null) {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Jvm();
                }
            }
        }
            return instance;
    }
}

