package MyGame.MyGameCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import static MyGame.MyGameCode.Constant.GAME_HEIGHT;
import static MyGame.MyGameCode.Constant.GAME_WIDTH;

/**
 * @description: 飞机游戏的主窗口
 * @Time: 2018/8/7 10:42
 */
public class MyGameFrame extends JFrame {
    /* 加载图片对象 */
    Image bg = MyGUI.getImage("MyGame/Image/bg.jpg");
    Image fly = MyGUI.getImage("MyGame/Image/plane.png");

    /* 新建一个飞机对象 */
    Plane plane = new Plane(fly, 250, 250);

    /* 炮弹类数组 */
    Shell[] shells = new Shell[50];

    /* 新建爆炸对象 */
    BoomAnim bo;        //这里不能直接new bo=new BoomAnim(plane.x,plane.y);如果new了那么x，y就固定了，得到后面才能新建

    /* 新建时间变量用以计时 */
    Date startTime = new Date();
    Date endingTime;
    double finalTime;       //游戏持续时间

    /* 双缓冲技术（让窗口不再闪烁），其实加了和没加一样 */
    private Image offScreenImage = null;

    public void update(Graphics gra) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);   //游戏窗口宽高
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        gra.drawImage(offScreenImage, 0, 0, null);
    }
    /* 双缓冲结束 */

    /* 画笔 */
    @Override
    public void paint(Graphics g) {     //一个钩子函数，在awt里面会自动执行它
        g.drawImage(bg, 0, 0, null);     //插入图片

        plane.drawSelf(g);  //画飞机

            for (int i = 0; i < shells.length; i++) {       //因为多线程repait()的缘故，40ms就会再进行一次，所以碰撞检测放这
               if(plane.life==true) {
                   shells[i].draw(g);      //画炮弹
               }
                boolean coll = shells[i].getRect().intersects(plane.getRect());       //利用返回的矩形进行边界判断

                    if (coll) {       //如果碰上了
                    plane.life = false;
                    if (bo == null) {           //这个条件限定了它只能新建一个对象，如果没有这个条件，当炮弹碰上了一直走的时候会产生很多个对象，这样就导致图片显示不对劲
                        bo = new BoomAnim(plane.x, plane.y);
                        endingTime = new Date();      //同上，不能建在if外面，不然会新建很多个date
                        finalTime = (double) ((endingTime.getTime() - startTime.getTime())) / 1000;
                    }
                    bo.draw(g);
                }
                if (plane.life == false) {      //如果飞机炸了才执行
                    //Font beginFont = getFont();
                    //Font f=ne
                    Color col = Color.getColor(null);
                    g.setColor(Color.white);
                    //g.setFont(f);

                    g.drawString("你才只有" + finalTime + "秒呀", 100, 250);

                    g.setColor(col);        //保持原样
                    // g.setFont(beginFont);       //同上
                }
            }
    }

    /**
     * 多线程，帮我们反复的重画窗口
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();

                try {
                    Thread.sleep(40);        //40ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 键盘监听
     */
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.redoDirection(e);
        }
    }

    /* 初始化窗口 */
    public void launchFrame() {
        this.setTitle("Fly Game");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setLocation(100, 100);

        this.setVisible(true);      //这句话要放到最后否则会黑屏

        /* 用于让关闭按钮正常关闭（现在只是结束窗口，并没有结束程序）*/
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start();      //启动重画窗口的线程 , 有了这个线程，整个画面才会动起来
        addKeyListener(new KeyMonitor());       //给窗口添加键盘监听

        for (int i = 0; i < shells.length; i++) {       //新建若干个炮弹对象数组
            shells[i] = new Shell();
        }
    }


    public static void main(String[] args) {
        MyGameFrame mgf = new MyGameFrame();
        mgf.launchFrame();
    }
}
