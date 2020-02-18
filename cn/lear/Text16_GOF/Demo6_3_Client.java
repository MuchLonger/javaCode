package cn.lear.Text16_GOF;

/**
 * @description: 桥接模式客户端测试
 * @Time: 2018/8/25 11:37
 */
public class Demo6_3_Client {
    public static void main(String[] args){
        //销售联想台式机
        Demo6_2_Computer computer=new Desktop(new Lenovo());
        computer.sale();




    }

}
