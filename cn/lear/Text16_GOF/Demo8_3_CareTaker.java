package cn.lear.Text16_GOF;

import java.util.Stack;

/**
 * @description:    备忘录模式练习：服务人类，负责管理(保存，取出）备忘录对象
 * @Time: 2018/8/26 14:36
 */
public class Demo8_3_CareTaker {

    private Demo8_1_EmpMemento memento;
    private Stack<Demo8_1_EmpMemento> stack = new Stack<>();


    public Demo8_1_EmpMemento getMemento() {
        return stack.pop();
    }

    public void setMemento(Demo8_1_EmpMemento memento) {
        stack.push(memento);
    }
}
