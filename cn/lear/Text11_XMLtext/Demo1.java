package cn.lear.Text11_XMLtext;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @Time: 2018/8/19 21:39
 */
public class Demo1 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // 1、先获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();        //不能用构造方法new，因为构造函数的访问权限是protected的，只能用静态
        // 2、从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();     //用对象新建
        // 4、编写处理器
        PersonHandler handler=new PersonHandler();

        // 3、加载文档的指定处理器
        parse.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("cn\\lear\\Text11_XMLtext\\person.xml"),handler);

        List<Person> list= handler.getPersons();

        for (Person p :
             list) {
            System.out.println(p.getAge()+","+p.getName()); //输出xml内的信息
        }
        String tag=null;
        System.out.println((tag!=null) && (tag.equals("age")));
        System.out.println((tag.equals("age")) && (tag!=null));
    }

}
