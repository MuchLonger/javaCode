package MyGame.MyGameCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @description: 用于导入图片
 * @Time: 2018/8/7 10:52
 */
public class MyGUI {
    /* 私有化构造器 */
    private MyGUI(){

    }
    /* 返回指定路径文件的图片 对象 */
    public static Image getImage(String path) {
        URL u=MyGUI.class.getClassLoader().getResource(path);
        BufferedImage bi=null;
        try{
            bi= ImageIO.read(u);
        }catch(IOException e){
            e.printStackTrace();
        }
        return bi;
    }
}
