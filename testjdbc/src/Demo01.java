import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试数据库链接
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(链接对象内部其实包含了Socket对象，是一个远程链接，比较耗时！这是Connection对象管理的一个要点！)
            //真正开发中，为了提高小路，都会使用连接池来管理连接对象！
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT", "root", "qq297227742");
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
