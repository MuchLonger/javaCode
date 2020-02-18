package cn.lear.Text8_IOzifuliu;

import java.io.*;

/**
 * @description: 纯文本的复制,,仅限字符
 * @Time: 2018/8/14 14:28
 */
public class Demo3_copyFile {

    public static void main(String[] args) {
        File dest = new File("D:/_java/src/text/c.txt");
        File src = new File("D:/_java/src/text/a.txt");

        Reader re = null;
        Writer wr = null;
        try {
            re = new FileReader(src);
            wr = new FileWriter(dest);

            char[] flush = new char[10];
            int len = 0;

            while ((len = re.read(flush)) != -1) {
                wr.write(flush, 0, len);
            }


            wr.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (wr != null) {
                    wr.close();
                }if (re != null) {
                    re.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
