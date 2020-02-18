package cn.lear.Text16_GOF;

/**
 * @description: 如何使用Builder模式
 * @Time: 2018/8/24 15:55
 */
public class Demo1_6_Cilent {


    public static void main(String[] args) {

        Demo1_3_AirShiprDirector director = new Demo1_5_CqyAirShipDirector(new Demo1_4_CqyShipBuilder());

        Demo1_1_AirShip ship = director.directAirShip();  //一调用就组建好了

        System.out.println(ship.getEngine().getName());
        System.out.println(ship.getEscapeTower().getName());
        System.out.println(ship.getOrbitalModule().getName());
    }


}
