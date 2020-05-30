import java.sql.*;

/**
 * 测试时间处理（java.sql.Date,Time.Timestamp）
 */
public class Demo07 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(链接对象内部其实包含了Socket对象，是一个远程链接，比较耗时！这是Connection对象管理的一个要点！)
            //真正开发中，为了提高小路，都会使用连接池来管理连接对象！
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT", "root", "qq297227742");



            String sql = "insert into t_user (username,pwd,regTime,lastLoginTime) values (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"维维");
            ps.setString(2,"123456");
            Date date=new java.sql.Date(System.currentTimeMillis());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ps.setDate(3,date);
            ps.setTimestamp(4,timestamp);
            ps.execute();
            System.out.println("插入一个用户数据");



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
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
