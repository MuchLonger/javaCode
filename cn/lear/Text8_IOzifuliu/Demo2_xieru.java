package cn.lear.Text8_IOzifuliu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @description: 文件的写入
 * @Time: 2018/8/14 12:21
 */
public class Demo2_xieru {

    public static void main(String[] args) {

        File dest = new File("D:/_java/src/text/a.txt");

        Writer wr = null;
        try {
            wr = new FileWriter(dest,true);

            String str = new String("zxcvbnmasdfghjkl;qwertyuiop");

            wr.write(str);  //写入
            wr.append("什么");        //底部添加

            wr.flush();

        } catch (IOException e) {
            System.out.println("文件");
            e.printStackTrace();
        }finally {
            if(wr!=null){
                try {
                    wr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
