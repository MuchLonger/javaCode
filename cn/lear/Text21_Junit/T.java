package cn.lear.Text21_Junit;

/**
 * @description:    Junit的简单测试
 * @Time: 2018/9/3 15:38
 */
public class T {
    public int add(int x,int y){
        return x+y;
    }
    public double divide(int x,int y){
        return x/y;
    }

    public static void main(String[] args){
        int z=new T().add(3,5);
        System.out.println(z);
    }

}
