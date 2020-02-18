package cn.lear.Text16_GOF;



/**
 * @description:    飞船类，用来测试建造者模式
 * @Time: 2018/8/24 12:16
 */
public class Demo1_1_AirShip {
    private OrbitalModule orbitalModule;        //飞船组件，轨道舱
    private Engine engine;      //飞船组件，发动机
    private EscapeTower escapeTower;        //飞船组件，逃逸塔

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}

class OrbitalModule{        //实现类
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrbitalModule(String name) {
        this.name = name;
    }
}

class Engine{       //实现发动机
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine(String name) {
        this.name = name;
    }
}

class EscapeTower{      //实现逃逸舱
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EscapeTower(String name) {
        this.name = name;
    }
}