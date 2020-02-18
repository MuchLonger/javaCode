package cn.lear.Text8_IO;

import java.io.File;
import java.io.IOException;

/**
 * @description: 文件夹的复制，注意父目录不能拷贝到子目录中
 * @Time: 2018/8/14 10:25
 */
public class Demo6_copyDir {


    public static void main(String[] args) {
        //源目录
        File file1 = new File("D:\\_java\\src\\text");
        //目标目录
        File file2 = new File("D:\\_java\\src\\text\\c");
        copyDire(file1,file2);
    }
    /*  复制文件夹判断 */
    public static void copyDire(File src,File dest){
        if (src.isDirectory()) {            //在它的里面添加src所属的文件夹
            dest = new File(dest, src.getName());
            if(dest.getAbsolutePath().contains(src.getAbsolutePath())){     //解决父目录复制进子目录里的bug
                System.out.println("父目录不能拷贝到子目录中");
                return;
            }
        }
        copyDir(src,dest);
    }
    /*  复制文件夹具体实施 */
    public static void copyDir(File src, File dest) {
        if (src.isFile()) {       //如果是文件直接复制
            try {
                Demo5_copy.IOInput(src, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (src.isDirectory()) {
            dest.mkdirs();  //创建相应的文件夹目录

            for (File sub :
                    src.listFiles()) {     //之所以递归成功靠的是listFiles()，它返回当前文件夹下的所有文件。
                copyDir(sub,new File(dest,sub.getName()));
        }

        }
    }

}
