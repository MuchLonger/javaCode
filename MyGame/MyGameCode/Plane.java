package MyGame.MyGameCode;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @description: 飞机类
 * @Time: 2018/8/7 15:30
 */
public class Plane extends GameObject {
    int speed = 8;
    boolean left, right, down, up;
    boolean life = true;

    public Plane(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    /**
     * 重写父亲的代码
     */
    @Override
    public void drawSelf(Graphics g) {
        if (life) {
            g.drawImage(img, (int) x, (int) y, null);
        }

        if (left) {
            x -= speed;
        } else if (right) {
            x += speed;
        } else if (up) {
            y -= speed;
        } else if (down) {
            y += speed;
        }
    }


    /* 以下是控制飞机移动的 */

    /* 摁下某个键时增加相应的方向 用于摁下时*/
    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:      //visual Key
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }

    /* 取消相应的键 用于松手时*/
    public void redoDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:      //visual Key
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }
}
