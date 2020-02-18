package cn.lear.Text16_GOF;

import java.util.Observable;
import java.util.Observer;

/**
 * @description:  观察者模式练习： 观察者
 * @Time: 2018/8/26 12:13
 */
public class Demo7_2_ObserverA implements Observer {

    private int Mystate;  //保存改变目标的值

    @Override
    public void update(Observable o, Object arg) {
        Mystate=((Demo7_1_ConcreteSubject)o).getState();    //获得父类的保存
    }

    public int getMystate() {
        return Mystate;
    }

    public void setMystate(int mystate) {
        Mystate = mystate;
    }


}
