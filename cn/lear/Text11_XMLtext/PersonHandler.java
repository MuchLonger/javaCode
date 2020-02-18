package cn.lear.Text11_XMLtext;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:    xml的处理器，外部应该是个流的读取器，while（is.read())
 * @Time: 2018/8/19 22:19
 */
public class PersonHandler extends DefaultHandler {
    //存入Person对象
    private List<Person>  persons;

    //而person对象内存储的是xml内的值。
    private Person person;

    //记下标签，用于存储person的信息，详情在下面character方法内
    private String tag;

    /*  处理文档的开始  */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始");

        //在文档开始时新建存储person的List容器
        persons=new ArrayList<>();

    }

    /*   处理文档的结束  */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("结束");
    }

    /*     开始一个元素      */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println("开始一个元素"+qName);
        if(qName!=null){
            tag=qName;
        }
        if(qName!=null && qName.equals("person")){  //xml内每有一个person对象就执行新建person对象
            //新建一个person对象用于存储信息
            person=new Person();
        }
    }


    /*       结束一个元素        */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("结束一个元素"+qName);
        if(qName.equals("person")){     //在结束的时候
            //存进List容器内
            this.persons.add(person);
        }
        tag=null;       //结束的时候设置为空，，一定要设置为空，不然后面的characters内的tag会一直为age，因为后面不只是只有判断内的值，还有些person之类的值
    }



    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //注意 tag 要不等于null，且tag！=null要写在前面,
        if(tag!=null&&tag.equals("name")){
            person.setName(new String(ch,start,length));
        }
        else if(tag!=null&&tag.equals("age")){
            //将String类型的数转成Integer类型
            person.setAge(Integer.valueOf(new String(ch,start,length)));
        }
    }

    //提供外部使用类内的容器（获取xml的具体数值）
    public List<Person> getPersons() {
        return persons;
    }
}
