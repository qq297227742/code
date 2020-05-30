package udp;



import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基本类型： 接收端
 * 1、使用DatagramSocket 创建接收端 指定端口
 * 2、准备容器 封装成 DatagramPacket包裹
 * 3、阻塞式接受包裹receive(DatagramPacket p)
 * 4、分析数据 将字节数组还原为对应的类型
 * byte[]    getData()
 * int       getLength()
 * 5、释放资源
 */
public class UdpTypeServer {
    public static void main(String[] args) throws IOException {
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

        DataInputStream dis=new DataInputStream(new BufferedInputStream(new ByteInputStream(datas,len)));


        String string;
        string = dis.readUTF();
        int int1 = dis.readInt();
        boolean flag = dis.readBoolean();
        char c = dis.readChar();

        System.out.println(string+int1+flag+c);
        //5、释放资源
        server.close();
    }
}
