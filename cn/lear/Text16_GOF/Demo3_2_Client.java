package cn.lear.Text16_GOF;

/**
 * @description:    相当于笔记本（只有USB接口）
 * @Time: 2018/8/24 17:51
 */
public class Demo3_2_Client {
    Demo3_1_Request r=new Demo3_1_Request();
    public void text(Demo3_3_Target t){
       t.handleRea();
//r.request();
    }

    public static void main(String[] args){
        Demo3_2_Client c=new Demo3_2_Client();
        Demo3_4_Adpater a=new Demo3_4_Adpater();
        Demo3_5_Adpater2 a2=new Demo3_5_Adpater2(a);
        c.text(a2);

    }

}
