package cn.lear.Text13_Classtext;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @description: 测试脚本引擎 执行javascript代码
 * @Time: 2018/8/22 10:38
 */
public class Demo6_Script {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        /*        获取脚本引擎对象      */
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("js");  //传入一个引擎的名字

        /*       定义一个变量，变量会存到java里，也会存到JavaScript里      */
        engine.put("cqy", "good");
        String str = "var user={name:'cyy',age:18,school:['gduf','lhxx']};";

        str += "print(user.school);";

        //执行脚本;
        engine.eval(str);   //输出

        engine.eval("good='cqq12';");      //修改mapping的value值，这个作用是新增mapping内的值如现在是新增一对key=good，value=cqq12的键值对

        System.out.println(engine.get("good"));

        System.out.println("--------------------------------------");

        /*    定义函数    */
        engine.eval("function add(a,b){var sum=a+b;return sum;}");
        //取得接口，想要执行函数得先实现Invocable接口
        Invocable jsInvoke = (Invocable) engine;
        //执行js函数的方法
        Object result = jsInvoke.invokeFunction("add", 20, 13);     //利用这个函数，进行传值及运算
        System.out.println(result);

        System.out.println("--------------------------------------");


        /*      利用js代码导入java包，并使用其他包内的java类      */
        String jsCode = "var list=java.util.Arrays.asList([\"cqy\",\"cqq\",\"cyy\"]);";
        engine.eval(jsCode);        //执行完后会传进Map内；


        List<String> list2 = (List<String>) engine.get("list");     //取得map内的值，因为里面保存为list所以要转型
        for (String temp :
                list2) {
            System.out.println(temp);
        }


        System.out.println("--------------------------------------");

        /*    执行一个js文件，需将js文件置于src下     */
        URL url=Demo6_Script.class.getClassLoader().getResource("Text13_js.js");
        FileReader fr=new FileReader(url.getPath());        //获得绝对路径
        engine.eval(fr);
        fr.close();


    }

}
