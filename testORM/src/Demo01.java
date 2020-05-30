import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试使用Object[]封装一条记录
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection mySQLConnection = JDBCUtil.getMySQLConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list=new ArrayList<>();

        try {
            ps = mySQLConnection.prepareStatement("select empname,salary,age from emp where id >?");
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] objs=new Object[3];//一个Object数组封装了一条记录的信息！
                objs[0] = rs.getString(1);
                objs[1] = rs.getDouble(2);
                objs[2] = rs.getInt(3);
                list.add(objs);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Object[] obj :
                list) {
            System.out.println(Arrays.toString(obj));
        }

    }
}
