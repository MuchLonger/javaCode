package MyGame.MyGameCode;

import java.awt.*;

/**
 * @description: 爆炸的动画
 * @Time: 2018/8/7 17:43
 */
public class BoomAnim {
    double x, y;
    public BoomAnim(double x,double y){
        this.x=x;
        this.y=y;
    }


    static Image[] imgs = new Image[16];      //因为只爆炸一次，所以是静态的就行

    static {        //只初始化一次
        for (int i = 0; i < 16; i++) {
            imgs[i]=MyGUI.getImage("MyGame/explode/e"+(i+1)+".gif");
            //imgs[i].getWidth(null);
        }
    }
    int count=0;      //图片计数

    public void draw(Graphics g){
        if(count<=15){
            g.drawImage(imgs[count],(int)x,(int)y,null);
            count++;
        }
    }
}
