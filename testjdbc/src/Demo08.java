import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间处理（java.sql.Date,Time.Timestamp）取出时间段的数据
 */
public class Demo08 {

    /**
     * 将字符串代表的日期转为long数字（格式yyyy-MM-dd hh:mm:ss）
     * @param dateStr
     * @return
     */
    public static long strToDate(String dateStr) {

        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        try {
             date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(链接对象内部其实包含了Socket对象，是一个远程链接，比较耗时！这是Connection对象管理的一个要点！)
            //真正开发中，为了提高小路，都会使用连接池来管理连接对象！
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT", "root", "qq297227742");

            ps = connection.prepareStatement("select * from t_user where regTime>? and regTime<?");
            ps.setTimestamp(1,new Timestamp(strToDate("2020-05-06 00:00:00")));
            ps.setTimestamp(2,new Timestamp(strToDate("2020-05-06 23:59:59")));
             resultSet = ps.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2)+"---"+resultSet.getDate(4));
            }


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
