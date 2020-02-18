package cn.lear.Text14_Javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description: 尝试javassist的api
 * @Time: 2018/8/22 12:05
 */
public class Demo2_javassistAPI {
    /*     处理类的方法     */
    public static void test1() throws NotFoundException, IOException, CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.lear.Text14_Javassist.Emp");    //get方法获得已有的类

        byte[] bytes = cc.toBytecode();       //转化为字节码
        System.out.println(Arrays.toString(bytes));

        System.out.println(cc.getName());   //获取完整的类名（完整路径）
        System.out.println(cc.getSimpleName()); //获取简要的类名（只有类名）
        System.out.println(cc.getSuperclass()); //获得父类
        System.out.println(cc.getInterfaces()); //获得接口

    }


    /*            产生新的方法              */
    public static void test2() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.lear.Text14_Javassist.Emp");          //不能同时get相同的类（我在main一起运行text1和text2报错了，class is frozen
        /*            方式1              */
        //CtMethod cm1=CtMethod.make("public int add(int a,int b){return a+b;}",cc);

        /*            方式2              */
        CtMethod m = new CtMethod(CtClass.intType, "add",
                new CtClass[]{CtClass.intType, CtClass.intType}, cc); //一个方法头
        m.setModifiers(Modifier.PUBLIC);        //设置访问权限
        m.setBody("{System.out.println(\"text2方法执行成功\");return $1+$2;}");     //效果同方式1，$1,$2指的是传入的第一个形参(a)，第二个形参(b),其中$0为this

        cc.addMethod(m);        //添加进去

        /*            通过反射调用新生成的方法              */
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();     //通过无参构造器创建EMP对象

        Method method = clazz.getDeclaredMethod("add", int.class, int.class);   //获得了上述新建的方法
        Object result = method.invoke(obj, 700, 200); //invoke，调用里面的方法
        System.out.println(result);

    }

    /*             修改 获得的类内的方法             */
    public static void text3() throws NotFoundException, CannotCompileException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.lear.Text14_Javassist.Emp");

        CtMethod cm1 = cc.getDeclaredMethod("Hey", new CtClass[]{CtClass.intType});    //获得方法，参数2是一个数组，包含着里面的参数类型

        //将语句插入到所有语句的最前面
        cm1.insertBefore("System.out.println(\"这是传进来的insertBefore!，\"+$1);");

        //将语句插入到所有语句的最后面
        cm1.insertAfter("System.out.println(\"这是传进来的insertAfter!，\"+$1);");

        cm1.insertAt(19, "System.out.print(\"lineNum=19\");");      //在第19行的前面，注意，这个行数是整个java代码的行数，且不受动态添加的影响（就是固有的代码行数，不会因为insertAt多次之后行数改变）


        //利用反射调用方法
        Class clazz = cc.toClass();       //可以利用这样的方法获取class文件
        Object obj = clazz.newInstance();     //获取到对象
        Method m1 = clazz.getDeclaredMethod("Hey", int.class);
        Object result1 = m1.invoke(obj, 50);       //获取到传出值(如果没有return（返回值），则会等于null）

        System.out.println(result1);

    }

    /*            修改 获得的类内的属性              */
    public static void text4() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.lear.Text14_Javassist.Emp");

        /*            创建属性方式1              */
        //CtField cf1=CtField.make("private String cqy;",cc);

        /*            创建属性方式2              */
        CtField cf2 = new CtField(pool.get("java.lang.String"), "cqy", cc);     //String的参数
        cf2.setModifiers(Modifier.PRIVATE);     //设置访问权限
        cc.addField(cf2);


        //设置set，get的新方法
        cc.addMethod(CtNewMethod.getter("getCqy", cf2));
        cc.addMethod(CtNewMethod.setter("setCqy", cf2));


        Class clazz = cc.toClass();       //可以利用这样的方法获取class文件
        Object obj = clazz.newInstance();     //获取到对象


    }

    /*            构造器              */
    public static void text5() throws NotFoundException, CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("cn.lear.Text14_Javassist.Emp");

        CtConstructor[] cs = cc.getConstructors();
        for (CtConstructor ct :
                cs) {
            System.out.println(ct.getLongName());       //获取构造器的名称
            ct.insertAfter("System.out.println(\"cqyhandsome\");");
        }
    }
        /*            注解读取              */
        public static void text6() throws NotFoundException, ClassNotFoundException {
            CtClass cc=ClassPool.getDefault().get("cn.lear.Text14_Javassist.Emp");
            //因为上面的地址是类，所以注解只能读取到类外的
            Object[] all=cc.getAnnotations();      //获取所有的注解

            cqq c=(cqq) all[0];
            String name=c.name();
            int year=c.year();
            System.out.println(name+","+year);

        }


    public static void main(String[] args) throws IOException, CannotCompileException, NotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // test1();      //只能同时运行一个，因为javassist的缘故
        //test2();
        //text3();
        //text4();
       // text5();
        text6();
    }

}
