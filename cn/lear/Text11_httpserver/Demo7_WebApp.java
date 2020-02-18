package cn.lear.Text11_httpserver;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @Time: 2018/8/19 17:05
 */
public class Demo7_WebApp {
    //里面有两个map用来保存xml内写入的servlet信息和mapping信息
    private static Demo6_ServletContent contxt;

    static {     //静态代码块， 新建n个对象也仅仅只会初始化一次

        /*  以下的替代最下面的方法  */
        // 获取SAX工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser sax = null;
        try {
            //从工厂内获取解析器
            sax = factory.newSAXParser();

            //handler,  sax.parse的第二个参数，作用是读取xml内的值
            Demo10_1_WebHandler handler = new Demo10_1_WebHandler();

            //加载文档处理器，加入自己新建的handle处理器，经过这一步handler内就有了xml
            sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/lear/Text11_httpserver/web.xml"), handler);


            //下面是将List容器转化为map容器
            contxt = new Demo6_ServletContent();        //获取Demo6对象，利用里面的map存储

            //先将经过处理的 <servlet-mapping>内（即第二个大标签）的 xml数据放入contxt内的Mapping map容器内
            Map<String, String> mapping = contxt.getMapping();
            for (Demo10_3_Mapping map :
                    handler.getMappingList()) {
                List<String> urls = map.getUrlPattern();    //取出xml存储mapping的容器里面的 UrlPattern 容器

                for (String url :
                        urls) {     //要遍历容器才能取出里面的url值
                    //注意，存的是url-pattern，servlet-name（这样就不会出现同名然后被覆盖的情况）
                    mapping.put( url,map.getName());
                }
                
            }
            
            //将经过处理的 <servlet>内（即第一个大标签）放入contxt内的servlet容器内
            Map<String, String> servlet = contxt.getServlet();
            for (Demo10_2_Entity entity :
                    handler.getEntityList()) {      //遍历存储xml数据的容器
                //存的是servlet-name，servlet-class
                servlet.put(entity.getName(),entity.getSlc());
            }




        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*老方法，利用map来保存信息，这样写不方便，采用了上面的xml使用的方法

        Map<String, String> mapping = contxt.getMapping();
        mapping.put("/login", "login");
        mapping.put("/log", "login");
        mapping.put("/reg", "register");

        Map<String, String> servlet = contxt.getServlet();
        servlet.put("login", "cn.lear.Text11_httpserver.Demo8_LoginServlet");
        servlet.put("register", "cn.lear.Text11_httpserver.Demo9_RegServlet");

        */

        }


        //最后返回一个Servlet对象（内有doget和dopost方法）
        public static Demo4_Servlet getServlet (String url){
            if ((url == null) || (url = url.trim()).equals("")) { //如果地址为空
                return null;
            }

            //旧版的时候存进了对象，利用对象来实现
            // return contxt.getServlet().get( contxt.getMapping().get(url) );   //要求返回的是Servlet对象，且contxt.getServlet里保存的就是Servlet对象。通过 contxt.getMapping().get(url) 来找到上家

            //获得包名全称
            String name = contxt.getServlet().get(contxt.getMapping().get(url));   //要求返回的是Servlet对象，且contxt.getServlet里保存的就是Servlet对象。通过 contxt.getMapping().get(url) 来找到上家

            //反射的简单运用
            try {
                return (Demo4_Servlet) Class.forName(name).newInstance();        //同样的先获得包名，获得包名的方法就是 name内, newInstance实现构造函数的方法(所以得确保空构造的存在）。
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

            return null;
        }

    }
