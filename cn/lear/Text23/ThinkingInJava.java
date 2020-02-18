package cn.lear.Text23;

/**
 * @description:
 * @Time: 2019/3/16 10:13
 */
class Meal{
    private static long counter=0;
    private final long count=counter++;
    Meal(){
        System.out.println(counter);
        System.out.println("meal");
    }
}
class Bread{
    private static long counter=1;
    private final long count=counter++;

    Bread(){
        System.out.println(counter);
        System.out.println("Bread");
    }
}


public class ThinkingInJava{
    public static void main(String[] args) {
        new ThinkingInJava();

    }
}
