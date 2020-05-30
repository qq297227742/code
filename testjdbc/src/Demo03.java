import java.sql.*;

/**
 * 测试PreparedStatement的基本用法
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(链接对象内部其实包含了Socket对象，是一个远程链接，比较耗时！这是Connection对象管理的一个要点！)
            //真正开发中，为了提高小路，都会使用连接池来管理连接对象！
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT", "root", "qq297227742");

            //？占位符
            String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            //参数索引从1开始
            ps.setString(1,"赵六");
            ps.setString(2,"666");
            ps.setDate(3,new Date(System.currentTimeMillis()));
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
