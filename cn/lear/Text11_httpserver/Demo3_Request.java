package cn.lear.Text11_httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * @description: 封装request
 *
 * @Time: 2018/8/18 21:08
 */
public class Demo3_Request {
    //请求方式
    private String method;
    //请求资源路径
    private String url;

    private int len;

    //请求的参数的值，用map包装，且Map里面装个List（可能一对多）
    private Map<String, List<String>> parameterMapVal;

    public static final String BLANK = " ";
    public static final String CRLF = "\r\n";

    //输入流
    private InputStream is;

    //requestInfo内的值是浏览器的头信息（Server，Content-type那些），通过outputStream获取的
    private String requestInfo;

    public Demo3_Request() {
        method = "";
        url = "";
        parameterMapVal = new HashMap<>();
        requestInfo = "";
    }

    public Demo3_Request(Socket socket) {
        this();
        try {
            //传入流
            this.is = socket.getInputStream();
            byte[] data = new byte[20480];
//获取的是字节数组
            //将流内数据存入data中，并返回成长度。
            len = socket.getInputStream().read(data);
            //转成String，requestInfo内的值是Socket封装的信息
            requestInfo = new String(data);
            System.out.println("requestInfo:\n"+requestInfo);
            System.out.println("end");
        } catch (IOException e) {
            return;
        }

        //分析头信息。
        parseRequestInfo();
    }

    //拼字符串
    private void parseRequestInfo() {
        //如果为空或者去掉空格后为空
        if (requestInfo == null || (requestInfo = requestInfo.trim()).equals("")) {
            return;
        }

        // 第一步：先从首行分解出：请求方式（get，post），请求的路径，请求参数（如果是get方法就可能存在）

        String parmaString = "";  //这是接收请求的参数,即用户输入的参数

        //先获取第一行的信息。从requestInfo得出的是，GET /reg?cqy&123 HTTP/1.1
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));    //结束符是 /r/n 所以从0到CRLF

        int idx = requestInfo.indexOf("/");       //因为后面就是相对路径，所以肯定有 "/"，同时会有空格，后面使用时记得加上trim()

        //获取方法
        this.method = firstLine.substring(0, (firstLine.indexOf("T") + 1)).trim();      //此处与视频不同，我用自己的方法

        //获取相对路径
        String urlStr = firstLine.substring(idx, requestInfo.indexOf("HTTP/")).trim();  //这是中间那行的信息



        if (this.method.equalsIgnoreCase("post")) {     //忽略大小写的写法

            this.url = urlStr;      //也会有HTTP/,同时也有空格，所以要用trim
            parmaString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();    //可以用倒数的方式。(疑问，最后一句没有CRLF吗）

        } else if (this.method.equalsIgnoreCase("get")) {       //get可能存在参数，所以得先判断
            if (urlStr.contains("?")) {        //以问号为判断点

                String[] urlArray = urlStr.split("\\?");      //用split会更好，毕竟左边为路径，右边为参数，且\?有歧义得用转义字符
                this.url = urlArray[0];   //左边的值
                parmaString = urlArray[1];        //右边的值
//                System.out.println("url"+url+"parmaString: "+parmaString);

            } else {
                this.url = urlStr;        //像post一样被接收
            }
        }
        if (!parmaString.equals("")) {        //不能用null，用""，因为上面已经给了值""了
            parseParam(parmaString);
        } else {
            return;
        }
    }


    //让浏览器将符号转化成中文 ，用在放置的时候
    private String decode(String msg,String code){  //其中code为"UTF-8","JBK"这种
        try {
            return java.net.URLDecoder.decode(msg,code);
        } catch (UnsupportedEncodingException e) {
            // e.printStackTrace();
        }
        return null;
    }



    //第二步：将参数信息传入到Map容器内。paramString的值是：myName=cqy&pwd=123456
    private void parseParam(String paramString) {
        //先将文本分割，因为值与值之间用&符号相隔
        StringTokenizer token = new StringTokenizer(paramString, "&");     //用法与split一致。一样是分割字符串

        while (token.hasMoreTokens()) {   //判断token内是否还有参数

            String Keyvalue = token.nextToken();  //获取当前token内的一个值

            //继续分割，获取Map的左右值
            String[] keyValues = Keyvalue.split("=");

            if (keyValues.length == 2) {        //就是键和值都存在的时候

                String key = keyValues[0].trim();     //获得键值
                //如果值为null则为null，否则就是原来的值
                String value = (null == keyValues[1] ? null : decode(keyValues[1].trim(),"UTF-8"));     //获得数值

                //当不存在key值时就新建一个进去
                if (!parameterMapVal.containsKey(key)) {

                    parameterMapVal.put(key, new ArrayList<>());

                }//剩下的就都是存在的了，一起处理。

                List<String> values = parameterMapVal.get(key);   //get（key）返回的是value值，又因为 value值是list，所以直接add进去就行了
                //将右侧的值添加进去。
                values.add(value);


            } else if (keyValues.length == 1) {      //如果只有名字(name)属性那就将值赋为null（注意是对象的null，不是"null"字符串)
                keyValues = Arrays.copyOf(keyValues, 2);  //扩充keyValues的内存，让其的length变成2个。 copyof两个参数的作用是（数组，复制的长度）如果参数2长度大于数组长度则填充0。即现在的值是 keyValues,0。
                keyValues[1] = null;  //将第一位变成null

            }

        }
    }

    //获取Map多个value值的方法  （因为value可能不止一个值）
    public String[] getParameterValues(String name) {
        List<String> values = null;       //先定义一个value容器
        if ((values = parameterMapVal.get(name)) == null) {
                return null;
        } else {
            return values.toArray(new String[0]);   //返回String类型的数组
        }
    }



    //这个方法用来 获取Map一个值
    public String getParamVal(String keyname) {
        String[] ValArrays = getParameterValues(keyname);   //调用上面获取多个值的方法
        if (ValArrays == null) {
            return null;
        }
        return ValArrays[0];
    }

    //获取相对路径
    public String getUrl() {
        return url;
    }
}

