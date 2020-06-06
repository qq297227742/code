package mvcapp.db;



import com.mchange.v2.c3p0.*;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC 操作工具类
 */
public class JdbcUtils {

    private static ComboPooledDataSource dataSource = null;

    static {
        //数据源只能被创建一次
        dataSource = new ComboPooledDataSource();

    }
    /**
     * 释放 Connection 连接
     * @param connection
     */
    public static void releaseConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 返回数据源的一个 Connection 对象
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
