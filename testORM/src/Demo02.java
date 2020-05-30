import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 测试使用Map封装一条记录
 * 使用List<Map>储存多条记录
 */
public class Demo02 {
    public static void test01() {
        Connection mySQLConnection = JDBCUtil.getMySQLConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //使用一个Map封装一条记录
        Map<String,Object> row=new HashMap<>();
        try {
            ps = mySQLConnection.prepareStatement("select empname,salary,age from emp where id >?");
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while (rs.next()) {
                row.put("empname", rs.getString(1));
                row.put("salary", rs.getDouble(2));
                row.put("age", rs.getInt(3));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (String s : row.keySet()) {
            System.out.println(s+"---"+row.get(s));
        }
    }

    public static void test02() {
        Connection mySQLConnection = JDBCUtil.getMySQLConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;


        List<Map<String,Object>> list=new ArrayList<>();

        try {
            ps = mySQLConnection.prepareStatement("select empname,salary,age from emp where id >?");
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while (rs.next()) {
                //使用一个Map封装一条记录
                Map<String,Object> row=new HashMap<>();
                row.put("empname", rs.getString(1));
                row.put("salary", rs.getDouble(2));
                row.put("age", rs.getInt(3));

                list.add(row);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Map<String,Object> row:list) {
            for (String s : row.keySet()) {
                System.out.println(s + "---" + row.get(s));
            }
        }
    }
    public static void main(String[] args) {

        test02();

    }
}
