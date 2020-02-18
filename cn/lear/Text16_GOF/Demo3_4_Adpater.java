package cn.lear.Text16_GOF;

/**
 * @description: 适配器。连接USB与PS/2的适配器(继承的方式）
 * @Time: 2018/8/24 17:54
 */
public class Demo3_4_Adpater extends  Demo3_1_Request implements Demo3_3_Target{

    @Override
    public void handleRea() {
        request();
    }
}
