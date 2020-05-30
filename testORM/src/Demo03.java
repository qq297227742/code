import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试使用JavaBean对象封装一条记录
 * 使用List<JavaBean>储存多条记录
 */
public class Demo03 {
    public static void test01() {
        Connection mySQLConnection = JDBCUtil.getMySQLConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //使用一个Map封装一条记录
        Emp emp=null;
        try {
            ps = mySQLConnection.prepareStatement("select empname,salary,age from emp where id >?");
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp=new Emp();
                emp.setEmpname(rs.getString(1));
                emp.setSalary(rs.getDouble(2));
                emp.setAge(rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(emp.getEmpname()+"--"+emp.getSalary()+"--"+emp.getAge());
    }

    public static void test02() {
        Connection mySQLConnection = JDBCUtil.getMySQLConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;


        List<Emp> list=new ArrayList<>();

        try {
            ps = mySQLConnection.prepareStatement("select empname,salary,age from emp where id >?");
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while (rs.next()) {
                //使用一个JavaBean 封装一条记录
                Emp emp=new Emp();
                emp.setEmpname(rs.getString(1));
                emp.setSalary(rs.getDouble(2));
                emp.setAge(rs.getInt(3));

                list.add(emp);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Emp  emp:list) {
            System.out.println(emp.getEmpname()+"--"+emp.getSalary()+"--"+emp.getAge());
        }
    }
    public static void main(String[] args) {

        test02();
        

    }
}
