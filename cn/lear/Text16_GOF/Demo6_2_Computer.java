package cn.lear.Text16_GOF;

/**
 * @description: 桥接模式练习：模拟电脑的类型
 * @Time: 2018/8/25 11:28
 */
public class Demo6_2_Computer {
    protected Demo6_1_Brand brand;

    public Demo6_2_Computer(Demo6_1_Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
    }

}

/*            模拟台式电脑              */
class Desktop extends Demo6_2_Computer { //父类有构造方法所以子类得实现父类的构造方法
    public Desktop(Demo6_1_Brand b) {    //传给父类
        super(b);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}

/*            模拟笔记本电脑              */
class Laptop extends Demo6_2_Computer { //父类有构造方法所以子类得实现父类的构造方法
    public Laptop(Demo6_1_Brand b) {    //传给父类
        super(b);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}