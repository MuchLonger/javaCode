package cn.lear.Text11_httpserver;

/**
 * @description:    这是另一个响应的文件 register
 * @Time: 2018/8/19 17:22
 */
public class Demo9_RegServlet extends Demo4_Servlet {

    @Override
    public void doGet(Demo3_Request req, Demo2_Response rep) throws Exception {

    }

    @Override
    public void doPost(Demo3_Request req, Demo2_Response rep) throws Exception {
        StringBuilder responseContent = new StringBuilder();
        responseContent.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>注册</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t\n" +req.getUrl()+"你好！"
                +req.getParamVal("myName")+ "，注册成功" +
                "</body>\n" +
                "</html>");
        //写入
        rep.print(responseContent);     //response的写入
    }

}
