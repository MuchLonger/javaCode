package cn.lear.Text8_IO;

import java.io.*;

/**
 * @description: 复制新方法，BufferInputStream实现
 * @Time: 2018/8/14 14:55
 */
public class Demo4_1_copyNew {

    public static void IOInput2(File src, File dest) {
        //选择流
        BufferedReader re = null;         //不能发生多态
        BufferedWriter wr = null;     //不能发生多态
        try {
            re = new BufferedReader(new FileReader(src));

            wr = new BufferedWriter(new FileWriter(dest));

            if (dest.isDirectory()) {
                System.out.println("不能建立于文件同名的文件");
                throw new IOException("不能建立于文件同名的文件");
            }

            String line = null;
            while ((line = re.readLine()) != null) {      //读取不为空的每一行
                wr.write(line);
                wr.newLine();       //换行符

            }
            //强制刷出
            wr.flush();

            //关闭流，先打开的后关闭
            wr.close();
            re.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File dest = new File("D:/_java/src/text/t.txt");
        File src = new File("D:/_java/src/text/a.txt");
        IOInput2(src, dest);
    }
}




