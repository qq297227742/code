import java.io.*;
import java.util.Date;

/**
 * 对象流
 * 1、先写出后读取
 * 2、读取的顺序与写出的保持一致
 *
 * DataOutputStream
 * DataInputStream
 * @author weiwei
 */
public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出--序列化
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
            //操作数据类型+数据
        objectOutputStream.writeUTF("编码辛酸泪");
        objectOutputStream.writeInt(18);
        objectOutputStream.writeBoolean(false);
        objectOutputStream.writeChar('a');
        //写入对象
        objectOutputStream.writeObject("谁解其中味");
        objectOutputStream.writeObject(new Date());

        Employee emp=new Employee("马云",400.0);
        objectOutputStream.writeObject(emp);

        objectOutputStream.flush();
        byte[] datas = byteArrayOutputStream.toByteArray();
        System.out.println(datas.length);
        //读取--反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一致
        String string;
        string = objectInputStream.readUTF();
        int int1 = objectInputStream.readInt();
        boolean flag = objectInputStream.readBoolean();
        char c = objectInputStream.readChar();

        Object str = objectInputStream.readObject();
        Object date=objectInputStream.readObject();
        Object employee =  objectInputStream.readObject();

        if (str instanceof String) {
            String strObject= (String) str;
            System.out.println(strObject);
        }

        if (date instanceof Date) {
            Date dateObject= (Date) date;
            System.out.println(dateObject);
        }

        if (employee instanceof Employee) {
            Employee employeeObject = (Employee) employee;
            System.out.println(employeeObject);
            System.out.println(employeeObject.getName()+"-->"+employeeObject.getSalary());
        }

        System.out.println(string+int1+flag+c);

    }
}


//javaBean 封装数据
class Employee implements Serializable {
    //transient 不需要序列化
    private transient String name;
    private Double salary;

    public Employee() {
    }

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}