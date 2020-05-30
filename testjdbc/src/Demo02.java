import java.sql.*;

/**
 * 测试执行SQL语句，以及SQL注入问题
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(链接对象内部其实包含了Socket对象，是一个远程链接，比较耗时！这是Connection对象管理的一个要点！)
            //真正开发中，为了提高小路，都会使用连接池来管理连接对象！
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT", "root", "qq297227742");

            Statement stmt = connection.createStatement();
//            String sql="insert into t_user (username,pwd,regTime) values('王五',5555,now())";
//            stmt.execute(sql);


            //测试SQL注入
            String sql = "delete from t_user where id=3 or 1=1";
            stmt.execute(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
