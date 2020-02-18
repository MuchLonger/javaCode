package cn.lear.Text16_GOF;

/**
 * @description:    船的实现类
 * @Time: 2018/8/24 15:45
 */
public class Demo1_4_CqyShipBuilder implements Demo1_2_AirShipBuilder{
    @Override
    public Engine builderEngine() {
        System.out.println("(1_4)构建发动机");
        return new Engine("cqy发动机");        //这个new可以使用工厂来实现（更简易）
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("(1_4)轨道舱");
        return new OrbitalModule("cqy轨道舱");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("(1_4)构建逃逸塔");
        return new EscapeTower("cqy逃逸塔");
    }




}
