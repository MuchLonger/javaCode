package cn.lear.Text9_Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @description:    Timer 计时器练习
 * @Time: 2018/8/16 22:55
 */
public class Demo11_Timer {

    public static void main(String[] args){
        Timer timer=new Timer();
        //解析TimerTask为任务，newDate即延迟1s后再执行，每0.2s执行一次
        //功能： 每
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("Timer练习");
            }
        },new Date(
                System.currentTimeMillis()+1000
        ),200);


    }
}
