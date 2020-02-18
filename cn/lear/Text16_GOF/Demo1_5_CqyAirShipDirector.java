package cn.lear.Text16_GOF;

/**
 * @description: 将所有零件组装好
 * @Time: 2018/8/24 15:49
 */
public class Demo1_5_CqyAirShipDirector  implements  Demo1_3_AirShiprDirector{

    private Demo1_2_AirShipBuilder builder;     //传入相应的对象

    public Demo1_5_CqyAirShipDirector(Demo1_2_AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Demo1_1_AirShip directAirShip() {
        /*            这是分别调用组建的方法（即先构造好零件）              */
        Engine e=builder.builderEngine();
        OrbitalModule o=builder.builderOrbitalModule();
        EscapeTower eT=builder.builderEscapeTower();

        /*            这是将组建全部添加到飞船内              */
        Demo1_1_AirShip ship=new Demo1_1_AirShip();
        ship.setEngine(e);
        ship.setEscapeTower(eT);
        ship.setOrbitalModule(o);


        return ship;    //返回
    }
}
