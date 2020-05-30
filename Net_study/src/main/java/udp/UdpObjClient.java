package udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * 引用类型：发送端
 *  1、使用DatagramSocket 创建发送端 指定端口
 *  2、将基本类型 转成字节数组
 *  3、封装成 DatagramPacket包裹，需要指定目的地
 *  4、发送包裹send(DatagramPacket p)
 *  5、释放资源
 */
public class UdpObjClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。。");
        //使用DatagramSocket 创建发送端 指定端口
        DatagramSocket client=new DatagramSocket(8888) ;
        // 准备数据 一定要转成字节数组
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
        // 封装成 DatagramPacket包裹，需要指定目的地
        DatagramPacket packet;
        packet = new DatagramPacket(datas, datas.length,new InetSocketAddress("localhost",9999));
        //发送包裹send(DatagramPacket p)
        client.send(packet);
        //释放资源
        client.close();
    }
}
