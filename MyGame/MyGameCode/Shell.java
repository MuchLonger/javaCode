package MyGame.MyGameCode;

import java.awt.*;

/**
 * @description: 炮弹类
 * @Time: 2018/8/7 15:47
 */
public class Shell extends GameObject {
    double degree;      //炮弹的角度

    /**
     * 初始化
     */
    public Shell() {
        x = 200;
        y = 200;
        width = 10;
        height = 10;
        speed = Constant.SPEED;      //代表着直角三角形的斜边，斜边越长，则数组越快

        degree = Math.random() * Math.PI * 2;       //让子弹随机角度飞
    }

    public void draw(Graphics g){       //这个类是会一直自动执行的
        Color color=g.getColor();       //保存以前的颜色
        g.setColor(Color.yellow);
        g.fillOval((int)x,(int)y,width,height);

        x+=speed*Math.cos(degree);          //利用三角函数求出x轴
        y+=speed*Math.sin(degree);          //同上求出y轴

        if(x<10||x>Constant.GAME_WIDTH-width-10){
            degree=Math.PI-degree;      //反弹机制，通过角度变换，而角度变换就靠这个减法
        }
        if(y<40||y>Constant.GAME_HEIGHT-height-10){        //因为标题栏也算上高度，所以得小于30
            degree=-degree;         //按角度相反的方向(经过windows画图后得出结果）
        }
        g.setColor(color);
    }
}
