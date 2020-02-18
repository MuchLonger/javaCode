package cn.lear.Text9_Thread;

/**
 * @description: 静态代理模式理解
 * @Time: 2018/8/16 11:10
 */
public class Demo2_Staticproxy {

    public static void main(String[] args) {
        //真实角色
        Marry you = new You();
        //代理角色
        WeddingCompany wc = new WeddingCompany(you);
        wc.marry();

    }

}

interface Marry {
    void marry();
}

class You implements Marry {
    @Override
    public void marry() {
        System.out.println("结婚了");
    }


}

class WeddingCompany implements Marry {
    private Marry You;

    public WeddingCompany() {
    }

    public WeddingCompany(Marry you) {
        You = you;
    }

    private void before() {
        System.out.println("布置");
    }

    private void after() {
        System.out.println("收钱");
    }

    @Override
    public void marry() {
        before();
        You.marry();
        after();
    }
}