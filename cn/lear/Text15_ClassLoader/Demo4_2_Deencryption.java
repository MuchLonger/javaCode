package cn.lear.Text15_ClassLoader;

import cn.lear.Text8_IO.Demo10_autoclose;

import java.io.*;

/**
 * @description:    加载文件系统内的被加密(Demo4_1处理后）后的文件，总体与Demo2一致，不同的是getClass方法内的读取流，需要取反，取反后就回归正常
 * @Time: 2018/8/23 12:20
 */
public class Demo4_2_Deencryption extends ClassLoader {
    //根目录
    private String rootDir;

    //初始化根目录
    public Demo4_2_Deencryption(String rootDir) {
        this.rootDir = rootDir;
    }

    //重写父类方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);      //查找已加载的类，看看是否已被加载
        //如果已经加载过，直接返回加载过的类
        if (c != null) {
            return c;
        } else {       //如果没有加载过
            ClassLoader parent = this.getParent();        //获得父级类加载器
            try {
                c = parent.loadClass(name);       //让父亲去加载
            } catch (ClassNotFoundException e) {
            }

            if (c != null) {        //同上
                return c;
            } else {

                byte[] classData = getClassData(name);    //getClassData是自己写的方法，作用是通过将一个类传进去，然后返回一个字节数组
                if (classData == null) {
                    throw new ClassNotFoundException("Class没有被响应");     //如果还是不能读取。则手动抛出异常
                } else {
                    String[] arr=name.split("\\.");
                    c = defineClass(arr[arr.length-1], classData, 0, classData.length);       //类名，字节数组，偏移量，长度
                    return c;
                }
            }
        }
    }

    /*         通过将一个类传进来，然后返回一个字节数组                 */
    private byte[] getClassData(String classname) {
        String path = rootDir + "/" + classname.replace(".", "/") + ".class";        //构成一个.class文件的完整路径

        InputStream is = null;       //获取输入流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();      //获取文档输出流，写入到byte数组内
        byte[] flush = new byte[1024];
        int len = 0;
        try {
            is = new FileInputStream(path);

            /*            与Demo2不同的地方              */
            int aByte=-1;       //一个字节
            while((aByte=is.read())!=-1){      //一次读一个字节
                bos.write(aByte^0xff);
            }

            return bos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;         //记得返回null
        } catch (IOException e) {
            e.printStackTrace();
            return null;        //记得返回null
        }finally {
            Demo10_autoclose.closeAll(is, bos); //关闭
        }
    }


}
