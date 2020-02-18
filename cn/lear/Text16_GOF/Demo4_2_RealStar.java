package cn.lear.Text16_GOF;

/**
 * @description: 静态代理模式练习：真实的角色
 * @Time: 2018/8/24 20:44
 */
public class Demo4_2_RealStar implements Demo4_1_Star {

    //除了唱歌，其他的都可以随意
    @Override
    public void confer() {
        System.out.println("Demo4_2_RealStar.confer");
    }

    @Override
    public void signContract() {
        System.out.println("Demo4_2_RealStar.signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("Demo4_2_RealStar.bookTicket");
    }

    //本类真正要执行的
    @Override
    public void sing() {
        System.out.println("eson在唱歌！！！");
    }




    @Override
    public void collectMoney() {
        System.out.println("Demo4_2_RealStar.collectMoney");
    }
}
