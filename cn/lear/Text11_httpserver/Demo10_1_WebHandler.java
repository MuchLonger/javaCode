package cn.lear.Text11_httpserver;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: web.xml获取值
 * @Time: 2018/8/20 23:17
 */
public class Demo10_1_WebHandler extends DefaultHandler {
    //建立存储两个对象的容器
    //Demo10_2_Entity内存储的是servlet-name和servlet-class的信息
    private List<Demo10_2_Entity> entityList;
    //Demo10_3_Mapping内存储的是servlet-name和url-pattern（其中url因为有可能是一对多<如多个 /log /login对应一个文件处理>，所以使用容器来保存）的信息
    private List<Demo10_3_Mapping> mappingList;

    //建立这两个对象（作用看上面）
    private Demo10_2_Entity entity;
    private Demo10_3_Mapping mapping;

    //用来判断是否是mapping，因为到时判断时只有中间的值（实际输入的）所以无法判断出是mapping内的还是servlet内的
    private boolean isMap;

    //标记
    private String tag;

    /*     文档解析开始     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始");
        //初始化两个容器
        entityList = new ArrayList<>();
        mappingList = new ArrayList<>();
    }


    /*            大前提：每遇到一行都会将下面的5个方法执行一次              */
    /*  每一个元素的开始（如遇到<servlet>）都会执行， 每一行元素都会被while(is.read())  所以对象是随之不断新建的 */
    @Override
    //通过使用sout发现，uri和localName一直都没有值，
    //而qName的值是标签的内容如<web-app>（qName值为web-app），<servlet-name>（qName的值为servlet-name）这样子的
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        /* 测试参数值是什么
        System.out.println("uri:"+uri);
        System.out.println("localName:"+localName);
        System.out.println("qName:"+qName);
        System.out.println("-------------------");
        */

        if (qName != null) {         //记住，是qName不等于空时再保存tag标签
            tag = qName;
        }

        if (tag != null && tag.equals("servlet")) {    //视频中使用qName来对比，我尝试使用tag试试,且只有是servlet的时候才新建，其他servlet内的标签不会新建
            isMap = false;        //用来保存更方便

            //每遇到一个标签<servlet>都新建一个保存servlet的对象，然后初始化为空
            entity = new Demo10_2_Entity();


        } else if (tag.equals("servlet-mapping")) {
            isMap = true;

            //对象初始化，同上（不过是遇到servlet-mapping）
            mapping = new Demo10_3_Mapping();


        }
    }





    /*     文档内的数据，将其一个个赋值到startElement（）方法新建的对象内     */
    @Override
    //ch[]是整一段话，start是标签“>”的下一个位置，length是“<”之前的一个位置
    public void characters(char[] ch, int start, int length) throws SAXException {
        //xml的数据到这里来处理
        if (tag != null) {     //先判断tag是不是空

            //这一步之后就能通过截取获取到中间的值
            String str=new String(ch, start, length);       //流内的具体数据值，先写好方便后面添加
            if (isMap) {        //如果是mapping内的值的话

                if (tag.equals("servlet-name")) {
                    mapping.setName(str);
                }else if (tag.equals("url-parttern")){
                    mapping.getUrlPattern().add(str);       //添加进mapping内的容器里
                }


            } else {        //如果是servlet内的值的话


                if (tag.equals("servlet-name")) {
                    entity.setName(str);
                } else if (tag.equals("servlet-class")){
                    entity.setSlc(str);
                }


            }
        }

    }

    /*  每一个元素的结束，如遇到</servlet>，才会执行 */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //意味着xml已经解释完毕，可以成为一个完整的对象，于是将其加入本类的List内
        if(qName!=null){
            //只有遇到</servlet>才加入List内
            if(qName.equals("servlet")){            //只有当尾标签为sevlet时才执行
                //添加进本类的容器内
                entityList.add(entity);

            }else if(qName.equals("servlet-mapping")){
                //添加进本类的容器内
                mappingList.add(mapping);

            }
        }
        //再赋值为null，不然将一直是一样的值
        tag=null;   //记住赋值为null
    }


    /*   文档解析结束  */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("结束");
    }

    public List<Demo10_2_Entity> getEntityList() {
        return entityList;
    }

    public List<Demo10_3_Mapping> getMappingList() {
        return mappingList;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory=SAXParserFactory.newInstance();

        SAXParser sax= factory.newSAXParser();

        Demo10_1_WebHandler handler=new Demo10_1_WebHandler();

        sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/lear/Text11_httpserver/web.xml"),handler);

        System.out.println(handler.getEntityList());

    }
}

