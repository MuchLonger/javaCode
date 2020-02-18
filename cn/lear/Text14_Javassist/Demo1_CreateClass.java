package cn.lear.Text14_Javassist;

import javassist.*;

import java.io.IOException;

/**
 * @description: 测试使用javassist生成一个新类
 * @Time: 2018/8/22 11:38
 */
public class Demo1_CreateClass {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        //第一步，获取类池
        ClassPool pool = ClassPool.getDefault();
        //建类，后续操作都是通过它
        CtClass cc = pool.makeClass("cn.lear.Text14_Javassist.Emp");

        //创建属性
        CtField cf1 = CtField.make("private int empNp;", cc);       //规范
        CtField cf2 = CtField.make("private String ename;", cc);       //规范
        cc.addField(cf1);
        cc.addField(cf2);       //添加进去
        //创建属性结束

        //创建方法
        CtMethod cm1 = CtMethod.make("public int getEmpNp(){return empNp;}", cc);
        CtMethod cm2 = CtMethod.make("public void setEmpNp(int empNp){this.empNp=empNp;}", cc);
        CtMethod cm3 = new CtMethod(pool.get("cn.lear.Text14_Javassist.Emp"),"cs",new CtClass[ ] { CtClass.intType, CtClass.intType},cc);
        cc.addMethod(cm1);
        cc.addMethod(cm2);
        //创建方法结束

        //添加构造器
        CtConstructor ctConstructor=new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);  //新建构造器的方法，有参数的话就得将参数也送进去，因为没有String类型，所以得用pool.get(java.lang.String)来表示String
        ctConstructor.setBody("{this.empNp=empNp;this.ename=ename;}");  //方法体
        cc.addConstructor(ctConstructor);
        //添加构造器结束

        //将文件添加到指定的路径
        cc.writeFile("D:\\_java");     //将上面写好的类写入到指定的位置
        System.out.println("类，成功");




    }


}
