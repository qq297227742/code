import java.sql.*;

/**
 * 测试批处理基本用法
 */
public class Demo05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(链接对象内部其实包含了Socket对象，是一个远程链接，比较耗时！这是Connection对象管理的一个要点！)
            //真正开发中，为了提高小路，都会使用连接池来管理连接对象！
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT", "root", "qq297227742");

             //设为手动提交
            connection.setAutoCommit(false);

            long start = System.currentTimeMillis();
            stmt = connection.createStatement();
            for (int i = 0; i < 20000; i++) {
                stmt.addBatch("insert into t_user (username,pwd,refTime) values ('wei"+i+"',666666,now())");
            }
            stmt.executeBatch();

            //提交事务
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println(end-start);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
