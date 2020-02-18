package MyGame.MyGameCode;

import java.awt.*;

/**
 * @description: 定义游戏物体（飞机）的父类
 * @Time: 2018/8/7 15:20
 */
public class GameObject {
    public Image img;
    public double x, y;     //飞机坐标
    public int speed;
    public int width, height;       //飞机大小


    public GameObject(Image img, double x, double y, int speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject() {
    }

    /**
     * 写一个让飞机坐标改变的方法
     */
    public void drawSelf(Graphics g) {
        g.drawImage(img, (int) x, (int) y, null);

    }

    /**
     * 再写一个返回当前图形所在矩形的方法，便于后续碰撞检测
     *
     * @return
     */
    public Rectangle getRect() {
        return new Rectangle((int) x, (int) y, width, height);
    }


}
