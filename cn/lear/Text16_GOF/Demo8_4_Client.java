package cn.lear.Text16_GOF;

/**
 * @description: 备忘录模式练习：客户端练习
 * @Time: 2018/8/26 14:38
 */
public class Demo8_4_Client {


    public static void main(String[] args){
        Demo8_3_CareTaker taker=new Demo8_3_CareTaker();

        Demo8_1_Emp emp=new Demo8_1_Emp("cqy",18,50);

        System.out.println("1："+emp.getAge()+","+emp.getEname()+","+emp.getSalary());

         taker.setMemento(emp.memento());

         emp.setAge(20);
         emp.setEname("cyy");
         emp.setSalary(500);

        System.out.println("2："+emp.getAge()+","+emp.getEname()+","+emp.getSalary());

        emp.setAge(30);
        emp.setEname("cqq");
        emp.setSalary(700);

        taker.setMemento(emp.memento());

        System.out.println("3："+emp.getAge()+","+emp.getEname()+","+emp.getSalary());


        emp.recovery(taker.getMemento());

        System.out.println("4："+emp.getAge()+","+emp.getEname()+","+emp.getSalary());

        emp.recovery(taker.getMemento());

        System.out.println("5："+emp.getAge()+","+emp.getEname()+","+emp.getSalary());

    }


}
