import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试CLOB  文本大对象的使用
 * 包含：将字符串、文件内容插入数据库中的CLOB字段、将CLOB字段值读出来的操作
 */
public class Demo09 {

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

//            ps = connection.prepareStatement("insert into t_user (username,myinfo) values (?,?)");
//            ps.setString(1,"weiwei");
//
//            //将文本文件内容直接输入到数据库中
////            ps.setClob(2,new FileReader("d:/a.txt"));
//
//            //将程序中的字符串输入到数据库的CLOB字段中
//            ps.setClob(2,new BufferedReader(new InputStreamReader( new ByteArrayInputStream("AAAAA".getBytes()))));
//
//            ps.executeUpdate();

            ps = connection.prepareStatement("select * from t_user where id=?");
            ps.setInt(1, 8);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Clob myinfo = resultSet.getClob("myinfo");
                Reader reader = myinfo.getCharacterStream();

                int temp = 0;
                while ((temp = reader.read()) != -1) {
                    System.out.print((char)temp);
                }
            }

        } catch (ClassNotFoundException | SQLException | IOException e) {
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
