package mvcapp.dao;

import com.mysql.cj.jdbc.JdbcConnection;
import mvcapp.db.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *封装了基本CRUD 的方法，以供子类继承使用
 * 当前DAO直接在方法中获取数据库连接
 * 整个DAO 采取 DButils 解决方案
 * @param <T> 当前DAO处理的实体类的类型
 */
public class DAO<T> {
    private QueryRunner queryRunner=new QueryRunner();
    private Class<T> clazz;

    public DAO() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superclass;
             Type[] typeArgs = parameterizedType.getActualTypeArguments();
            if (typeArgs != null && typeArgs.length > 0) {
                if (typeArgs[0] instanceof Class) {
                    clazz = (Class<T>) typeArgs[0];
                }
            }
        }
    }

    /**
     * 返回某一个字段的值
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return (E) queryRunner.query(connection,sql,new ScalarHandler<>(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 返回 T 所对应的List
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForList(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }
    /**
     * 返回对应 T 的一个实例类对象
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(connection);
        }

        return null;
    }
    /**
     * 该方法封装了INSERT、DELETE、UPDATE 操作
     * @param sql   SQL语句
     * @param args  填充 SQL 语句占位符
     */
    public void update(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
    }
}
