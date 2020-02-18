package cn.lear.Text20_ORM;

import cn.lear.Text19_JDBC.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 练习Object relation Mapping。（使用Object数组封装一条数据）
 * @Time: 2018/8/28 14:53
 */
public class Demo1_ObjectArr {
    public static void main(String[] args) {
        //获取连接对象
        Connection conn = JDBCutil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;


        /*            建立Object数组容器来存储数据              */
        List<Object[]> list=new ArrayList<>();

        try {
            ps = conn.prepareStatement("select empName,salary,age from emp where id>=?");
            ps.setInt(1,1);


            rs = ps.executeQuery();



            while (rs.next()) {
                /*            Object[]只能放在里面，在外面就会出错（两个值是一样的），之所以会这样是因为里面的=运算是浅复制（放的是内存地址 ，所以后面输出的时候会是两个一样的值。              */
                Object[] objs=new Object[3];
                // System.out.println("名字:"+rs.getString(1)+"，薪水："+rs.getInt(2)+"，年龄："+rs.getInt(3));
                objs[0]=rs.getString(1);
                objs[1]=rs.getInt(2);
                objs[2]=rs.getObject(3);
                //使用容器保存数据
                list.add(objs);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeIts(rs,ps,conn);
        }

        for (Object[] obj :
                list) {
            System.out.println(""+obj[0]+obj[1]+obj[2]);
        }


    }

}
