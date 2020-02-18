package cn.lear.Text8_IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @description: 文件分割的实现
 * @Time: 2018/8/15 17:22
 */
public class Demt14_splitFile {
    //文件的路径
    private String filePath;
    //文件名
    private String fileName;
    //分成几块
    private int size;
    //每块的大小
    private long blockSize;
    //文件总长度
    private long Length;
    //每块的名称
    private List<String> blockPath;

    public Demt14_splitFile() {
        blockPath = new ArrayList<>();
    }

    public Demt14_splitFile(String filePath) {
        this(filePath, 16);
    }

    public Demt14_splitFile(String filePath, long blockSize) {
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        init();
        initPathName();
    }

    //初始化
    public void init() {
        File src = null;
        //如果路径为空，或者路径不存在
        if (null == filePath || !(src = new File(filePath)).exists()) {
            return;
        }
        if (src.isDirectory()) {
            return;
        }
        //获取文件字节的大小
        long length = src.length();
        if (this.blockSize > length) {      //如果默认的blockSize比原本的大则将当前的长度变成传入的长度
            this.blockSize = length;
        }
        //向上取整，得出要分成几块
        size = (int) (Math.ceil(length * 1.0 / this.blockSize));
        this.fileName = src.getName();
        this.Length = src.length();
    }

    //初始化文件名称
    public void initPathName() {
        for (int i = 0; i < size; i++) {
            this.blockPath.add("part_" + i + this.fileName);
        }
    }

    //文件分割,destPath为分割文件的存放目录
    //以下是自己实现的
    public void split(String destPath) throws IOException {
        long lastBlock = Length - (size - 1) * this.blockSize;
        long sizes;     //用于计算分块的累加和

        RandomAccessFile raf = new RandomAccessFile(new File(filePath), "r");  //随机读取对象

        int i = 1;

        for (String temp :
                this.blockPath) {
            String dest = destPath + "\\" + temp;
            BufferedOutputStream os = new BufferedOutputStream(
                    new FileOutputStream(dest)
            );


            if (i == size) {        //如果是最后一个了
                int count = (int) ((int) (i - 1) * this.blockSize);       //现在是第几位
                raf.seek(count);
                byte[] flush = new byte[(int) lastBlock];
                raf.read(flush);
                os.write(flush, 0, (int) lastBlock);       //写入长度lastBlock位

                os.flush();

                break;
            }

            sizes = (i * this.blockSize) - 1;   //-1是因为从0开始
            raf.seek((int) sizes);        //实现分块


            byte[] flush = new byte[(int) blockSize];
            raf.read(flush);
            os.write(flush, 0, (int) blockSize);     //照常写入

            os.flush();

            i++;
            os.close();
        }
    }


    //文件的合并
    public void mergeFile(String destPath) throws IOException {
        File dest = new File(destPath);     //输出位置
        BufferedInputStream bis = null;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest, true));    //添加到后面
        for (int i = 0; i < this.blockPath.size(); i++) {
            bis = new BufferedInputStream(new FileInputStream(new File("D:\\_java\\src\\text\\" + this.blockPath.get(i))));     //读取位置

            byte[] flush = new byte[1024];
            int len = 0;
            while ((len = bis.read(flush)) != -1) {
                bos.write(flush, 0, len);     //写入文件
            }
            bos.flush();
        }
        Demo10_autoclose.closeAll(bos, bis);     //关闭

    }

    //文件的合并2，利用sequenceInputStream
    public void mergeFile2(String destPath) throws IOException {
        File dest = new File(destPath);
        BufferedInputStream bis = null;
        SequenceInputStream sis = null;

        //创建一个容器
        Vector<InputStream> vi = new Vector<>();
        for (int i = 0; i < this.blockPath.size(); i++) {
            vi.add(new BufferedInputStream(new FileInputStream(new File("D:\\_java\\src\\text\\" + this.blockPath.get(i)))));
        }

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest, true));    //添加到后面
        //新方法。sis流里面装了Input流里面的东西，再用elements（）方法取出
        sis = new SequenceInputStream(vi.elements());

        byte[] flush = new byte[1024];
        int len = 0;
        while ((len = sis.read(flush)) != -1) {
            bos.write(flush, 0, len);
        }
        bos.flush();

        Demo10_autoclose.closeAll(sis, bos);
    }


    public static void main(String[] args) {
        Demt14_splitFile sf = new Demt14_splitFile("D:\\_java\\src\\text\\pruin.txt");

        try {
            //       sf.split("D:\\_java\\src\\text");
            sf.mergeFile2("D:\\_java\\src\\text\\b.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sf.size);

    }
}
