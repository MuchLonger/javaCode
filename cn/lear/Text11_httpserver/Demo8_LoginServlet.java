package cn.lear.Text11_httpserver;

/**
 * @description:    //这是一个响应的文件  login
 * @Time: 2018/8/19 17:19
 */
public class Demo8_LoginServlet extends Demo4_Servlet{


    @Override
    public void doGet(Demo3_Request req, Demo2_Response rep) throws Exception {
        if (login(req.getParamVal("myName"), req.getParamVal("pwd"))) {     //只有当用户名和密码都匹配时才允许进入
            StringBuilder responseContent = new StringBuilder();
            responseContent.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "\t<meta charset=\"UTF-8\">\n" +
                    "\t<title>Login</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\t\n" + req.getUrl() + "!"
                    + req.getParamVal("myName") + "你好！HelloWorld" +
                    "</body>\n" +
                    "</html>");
            //写入
            rep.print(responseContent);     //response的写入
        }
        else{
            StringBuilder responseContent = new StringBuilder();
            responseContent.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "\t<meta charset=\"UTF-8\">\n" +
                    "\t<title>Login</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\t\n" + "登陆失败"+
                    "</body>\n" +
                    "</html>");
            //写入
            rep.print(responseContent);     //response的写入
        }
    }

    public boolean login(String name,String pwd){
        return name.equals("cqy")&&pwd.equals("123456");
    }

    @Override
    public void doPost(Demo3_Request req, Demo2_Response rep) throws Exception {


    }
}
