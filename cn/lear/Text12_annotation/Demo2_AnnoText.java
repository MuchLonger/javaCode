package cn.lear.Text12_annotation;

/**
 * @description:    注解练习
 * @Time: 2018/8/21 16:00
 */
public class Demo2_AnnoText {

    @MyAnnotation(studentName="cqy",age = 16,id = 1)
    public void test(){
        System.out.println("cqy");
    }

}
