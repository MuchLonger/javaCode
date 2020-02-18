package cn.lear.text1;

/**
 * @description:
 * @Time: 2019/6/10 12:52
 */
public class father {
    public void a(){
        System.out.println("father");
    }
    public static void b(){
        System.out.println("static father");
    }
}
class son  extends father{
    @Override
    public void a() {
        System.out.println("son");
    }
    public static void b(){
        System.out.println("static son");
    }
}
class mains{
    public static void main(String[] args){
        father f=new father();
        father f1=new son();
        son s=new son();
        f1.a();

        System.out.println("---");
        f.a();
        f.b();
        System.out.println("---");
        s.a();
        s.b();

    }
}
