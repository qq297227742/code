import java.io.*;
import java.sql.*;

/**
 * 测试BLOB  二进制大对象的使用
 * 包含：将字符串、文件内容插入数据库中的CLOB字段、将CLOB字段值读出来的操作
 */
public class Demo10 {

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

         /*   ps = connection.prepareStatement("insert into t_user (username,headImg) values (?,?)");
            ps.setString(1,"weiwei");

            //将二进制文件内容直接输入到数据库中
            ps.setBlob(2,new FileInputStream("C:\\java\\code\\th3.jpg"));

            //将程序中的字符串输入到数据库的BLOB字段中
            ps.executeUpdate();*/

            ps = connection.prepareStatement("select * from t_user where id=?");
            ps.setInt(1, 11);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Blob headImg = resultSet.getBlob("headImg");
                InputStream binaryStream = headImg.getBinaryStream();
                OutputStream outputStream=new FileOutputStream("d:/th.jpg");
                byte[] bytes=new byte[1024];
                int len = -1;
                while ((len = binaryStream.read(bytes)) != -1) {
                    outputStream.write(bytes,0,len);
                }

            }

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
