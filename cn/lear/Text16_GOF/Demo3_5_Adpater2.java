package cn.lear.Text16_GOF;

/**
 * @description: 扮演适配器，使用的方式是组合。
 * @Time: 2018/8/24 18:06
 */
public class Demo3_5_Adpater2 implements  Demo3_3_Target{

    private Demo3_4_Adpater adpater;


    @Override
    public void handleRea() {
        adpater.request();
    }

    public Demo3_5_Adpater2(Demo3_4_Adpater adpater) {
        this.adpater = adpater;
    }

}
