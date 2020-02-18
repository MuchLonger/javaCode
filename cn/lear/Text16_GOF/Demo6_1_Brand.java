package cn.lear.Text16_GOF;

/**
 * @description: 桥接模式的实现： 模拟电脑品牌
 * @Time: 2018/8/24 22:50
 */
public interface Demo6_1_Brand {
    void sale();

}

class Lenovo implements Demo6_1_Brand{

    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Demo6_1_Brand{

    @Override
    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}
