package cn.lear.Text20_ORM;

import cn.lear.Text19_JDBC.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:    使用JavaBean保存数据库的值
 * @Time: 2018/8/28 21:19
 */
public class Demo3_JavaBean {
    public static void main(String[] args) {
        //获取连接对象
        Connection conn = JDBCutil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Emp> list=new ArrayList<>();
        try {
            ps = conn.prepareStatement("select empName,salary,age from emp where id>=?");
            ps.setInt(1, 1);


            rs = ps.executeQuery();


            while (rs.next()) {
                Emp emp=new Emp(rs.getString(1),rs.getInt(3),
                        rs.getDouble(2));
                list.add(emp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeIts(rs, ps, conn);
        }

        for (Emp e :
                list) {
            System.out.println(e.getAge()+"，"+e.getEmpName()+"，"+e.getSalary());
        }

    }

}
