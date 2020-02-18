package cn.lear.Text13_Classtext;

/**
 * @description:    测试Class对象的获取方式,以及相等情况，关联包：Text1的User
 * @Time: 2018/8/21 18:24
 */
public class Demo1_Class {

    public static void main(String[] args){
        String path="cn.lear.text.User";

        try {
            Class  cl= Class.forName(path);

            System.out.println(cl.hashCode());

            Class  c2= Class.forName(path);

            System.out.println(c2.hashCode());          //一个类对应一个对象。所有c1==c2
            System.out.println("-------------------------");
            //以下是String测试
            Class strCl=String.class;
            System.out.println(strCl.hashCode());

            Class strClx=path.getClass();
            System.out.println(strClx.hashCode());

            String b=new String("cq");
            Class strNew=b.getClass();
            System.out.println(strNew.hashCode());     //得出结果strCl==strClx==strNew

            System.out.println("---------------------------");
            //测试数组

            int[] arr01=new int[10];
            int[] arr02=new int[30];

            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());        //也是相同的

            System.out.println("---------------------");
            int[] arr03=new int[10];
            int[][] arr04=new int[30][20];

            System.out.println(arr03.getClass().hashCode());
            System.out.println(arr04.getClass().hashCode());        //就是不相同的了，维数不同就不是一个对象

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
