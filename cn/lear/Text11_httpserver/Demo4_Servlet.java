package cn.lear.Text11_httpserver;

/**
 * @description: 用来简化Demo1_Server的操作。
 *                   修改后，将其抽象成一个父类。
 * @Time: 2018/8/19 14:15
 */
public abstract class Demo4_Servlet {
    public void service(Demo3_Request req, Demo2_Response rep) throws Exception {
        this.doGet(req,rep);
        this.doPost(req,rep);
    }

    public abstract void doGet(Demo3_Request req, Demo2_Response rep) throws Exception;

    public abstract void doPost(Demo3_Request req, Demo2_Response rep) throws Exception;
}
