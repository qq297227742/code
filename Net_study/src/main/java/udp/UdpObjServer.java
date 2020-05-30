package udp;



import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 引用类型： 接收端
 * 1、使用DatagramSocket 创建接收端 指定端口
 * 2、准备容器 封装成 DatagramPacket包裹
 * 3、阻塞式接受包裹receive(DatagramPacket p)
 * 4、分析数据 将字节数组还原为对应的类型
 * byte[]    getData()
 * int       getLength()
 * 5、释放资源
 */
public class UdpObjServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1、使用DatagramSocket 创建接收端 指定端口
        DatagramSocket server=new DatagramSocket(9999);
        //2、准备容器 封装成 DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,container.length);
        //3、阻塞式接受包裹receive(DatagramPacket p)
        server.receive(packet);
        //4、分析数据
        // byte[]    getData()
        // int       getLength()

        byte[] datas = packet.getData();
        int len=packet.getLength();


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

        //5、释放资源
        server.close();
    }
}
