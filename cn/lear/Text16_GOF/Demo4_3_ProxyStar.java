package cn.lear.Text16_GOF;

/**
 * @description: 静态代理模式练习：代理角色
 * @Time: 2018/8/24 20:48
 */
public class Demo4_3_ProxyStar implements Demo4_1_Star {

    private Demo4_1_Star star;

    //到时传入Demo4_2_RealStar对象就能实现sing方法了
    public Demo4_3_ProxyStar(Demo4_1_Star star) {
        this.star = star;
    }

    //其他都能写内容，唯独sing不能写入自己的内容。
    @Override
    public void confer() {
        System.out.println("Demo4_3_ProxyStar.confer");
    }

    @Override
    public void signContract() {
        System.out.println("Demo4_3_ProxyStar.signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("Demo4_3_ProxyStar.bookTicket");
    }

    @Override
    public void collectMoney() {
        System.out.println("Demo4_3_ProxyStar.collectMoney");
    }


    /*            不能随意写              */
    @Override
    public void sing() {
        star.sing();        //使用的是真实角色的sing（）方法
    }

}
