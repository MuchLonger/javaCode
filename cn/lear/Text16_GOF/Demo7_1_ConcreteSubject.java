package cn.lear.Text16_GOF;

import java.util.Observable;

/**
 * @description: 观察者模式练习（用Observerable）,目标对象（改变者）
 * @Time: 2018/8/26 12:10
 */
public class Demo7_1_ConcreteSubject extends Observable {

    private int state;

    public void set(int s) { //设置值
        this.state = s;

        setChanged();   //表示目标对象已经做了改变（内部就是boolean型参数）
        notifyObservers(state); //通知所有的观察者

    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
