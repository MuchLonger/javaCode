package cn.lear.Text16_GOF;

import java.lang.reflect.Proxy;

/**
 * @description: 客户端体验
 * @Time: 2018/8/24 21:52
 */
public class Demo5_2_Client {
    public static void main(String[] args) {
        //传入真实明星（realStar）
        Demo4_1_Star star = new Demo4_2_RealStar();
        //传入handle对象
        Demo5_1_StarHandler handler = new Demo5_1_StarHandler(star);
        //调用代理方法
        Demo4_1_Star proxy = (Demo4_1_Star)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Demo4_1_Star.class}, handler);
        proxy.confer(); //confer是star的方法
        proxy.sing(); //真正明星实现的方法
    }


}
