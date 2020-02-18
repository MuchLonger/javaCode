package cn.lear.Text20_ORM;

import cn.lear.Text19_JDBC.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 利用map+map容器存储 多条 数据库里面的值
 * @Time: 2018/8/28 20:46
 */
public class Demo2_Map {
    public static void main(String[] args) {
        //获取连接对象
        Connection conn = JDBCutil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;


        /*            利用Map来存储map（一般都是用List，尝试用下Map）              */
        Map<String, Map<String, Object>> Maps = new HashMap<>();
        try {
            ps = conn.prepareStatement("select empName,salary,age from emp where id>=?");
            ps.setInt(1, 1);


            rs = ps.executeQuery();


            while (rs.next()) {
                //一定要放在里面
                Map<String, Object> row = new HashMap<>();
                row.put("empName", rs.getString(1));
                row.put("salary", rs.getString(2));
                row.put("age", rs.getString(3));
                //使用Map容器保存数据，key为empName的值
                Maps.put(rs.getString(1), row);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeIts(rs, ps, conn);
        }
        for (String empName : Maps.keySet()     //keySet（）返回Key值
        ) {
            for (String key :
                    Maps.get(empName).keySet()) {
                System.out.print(key + "，" + Maps.get(empName).get(key) + "\t");
            }
            System.out.println();
        }

    }
}
