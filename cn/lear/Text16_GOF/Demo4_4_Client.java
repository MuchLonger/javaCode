package cn.lear.Text16_GOF;

/**
 * @description: 静态代理模式练习： 客户
 * @Time: 2018/8/24 20:52
 */
public class Demo4_4_Client {

    public static void main(String[] args) {
        Demo4_1_Star star = new Demo4_2_RealStar();
        Demo4_3_ProxyStar proxyStar = new Demo4_3_ProxyStar(star);

        star.sing();
        star.confer();


        proxyStar.sing();
        proxyStar.confer();

    }

}
