package cn.lear.Text16_GOF;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 动态代理模式练习之 handle练习
 * @Time: 2018/8/24 21:49
 */
public class Demo5_1_StarHandler implements InvocationHandler {
    Demo4_1_Star realStar;  //传入真实角色

    public Demo5_1_StarHandler(Demo4_1_Star realStar) {
        this.realStar = realStar;
    }


    /*            代理类，调用方法，方法参数              */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=null;
        System.out.println("巴拉巴拉，一些其他事情");
        /*            只有方法名为sing的时候才会调用realStar底下的方法              */
        if(method.getName().equals("sing")) {   //只有sing的时候才会调用，其他就进不来
            /*            后期处理后，代理角色一直会执行这个realStar类方法              */
            obj=method.invoke(realStar, args);  //接收方法返回值
        }
        System.out.println("巴拉巴拉，一些其他的事情");
        return obj;
    }
}
