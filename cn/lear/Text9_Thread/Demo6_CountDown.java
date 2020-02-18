package cn.lear.Text9_Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:     利用sleep制作倒计时
 * @Time: 2018/8/16 16:05
 */
public class Demo6_CountDown {


    public static void main(String[] args) throws InterruptedException {
        Date endTime=new Date(System.currentTimeMillis()+10*1000);  //倒计时添加10s
        long end=endTime.getTime();     //记住当前时间，getTime返回以毫秒为单位的long数据
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));  //获得当前分钟与秒钟
            endTime=new Date(endTime.getTime()-1000);       //等于1s以前的数值
            Thread.sleep(1000);     //添加sleep，不然直接就输出了
            if(end-10000>endTime.getTime()){        //只倒计时10s，即如果超过当时定义的时间的话就取消
                break;
            }
        }
    }
}
