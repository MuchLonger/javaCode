package cn.lear.text;

/**
 * @description:
 * @Time: 2018/9/2 17:42
 */
public class demo5 {
    public static void main(String[] args){
        Long start=System.currentTimeMillis();
        for (int i = 0; i < 3333; i++) {
            for (int j = 0; j < 1433; j++) {
                for (int k = 0; k < 1143; k++) {

                }
            }

        }
        Long end=System.currentTimeMillis();
        System.out.println("用了"+(end-start)+"毫秒");
    }

}
