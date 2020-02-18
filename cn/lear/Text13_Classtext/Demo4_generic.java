package cn.lear.Text13_Classtext;

import cn.lear.text.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @description: 通过反射操作泛型信息。因为泛型是编译器执行的，当编译器执行完之后，在形成.class文件之前会将所有的泛型都清除，而反射是建立在.class文件之上的，所以泛型读取不到，而现在就是解决这个问题
 * @Time: 2018/8/21 22:51
 */
public class Demo4_generic {
    public void test1(Map<String, User> map, List<User> list) {
        System.out.println("Demo4_test1");
    }

    public Map<Integer, User> test02() {
        System.out.println("Demo4_test1");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {

        /*  以下是获取指定的方法的参数泛型信息   */
        Method m = Demo4_generic.class.getMethod("test1", Map.class, List.class);
        Type[] t = m.getGenericParameterTypes();  //获得泛型的参数类型，会将相应的泛型也获取到(java.util.Map<java.lang.String, cn.lear.text.User>)
        for (Type ty :
                t) {
            System.out.println("#" + ty);
            if (ty instanceof ParameterizedType) {        //看看type是不是一个参数类型（即map，list这些），如果是
                Type[] genericType = ((ParameterizedType) ty).getActualTypeArguments();   //getActualTypeArguments()方法是用来获取真正的泛型的参数类型，如Map<String,User>内的String与User,该方法属于ParameterizedType所以需要转型
                for (Type gen :
                        genericType) {
                    System.out.println("泛型的类型为：" + gen);
                }
            }
        }

        System.out.println("--------------------------------");
        //获得指定方法的返回值类型
        Method m2 = Demo4_generic.class.getMethod("test02",null);
        Type t2 = m2.getGenericReturnType();        //这里有不同，是ReturnType ，剩下的基本同上
        if (t2 instanceof ParameterizedType) {  //如果属于泛型
            Type[] genericTypes = ((ParameterizedType) t2).getActualTypeArguments();
            for (Type gen :
                    genericTypes) {
                System.out.println("返回值：泛型的类型为：" + gen);
            }
        }

    }


}
