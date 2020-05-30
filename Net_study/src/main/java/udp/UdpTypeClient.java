package udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本类型：发送端
 *  1、使用DatagramSocket 创建发送端 指定端口
 *  2、将基本类型 转成字节数组
 *  3、封装成 DatagramPacket包裹，需要指定目的地
 *  4、发送包裹send(DatagramPacket p)
 *  5、释放资源
 */
public class UdpTypeClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。。");
        //使用DatagramSocket 创建发送端 指定端口
        DatagramSocket client=new DatagramSocket(8888) ;
        // 准备数据 一定要转成字节数组
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream( new BufferedOutputStream(baos));
        dos.writeUTF("编程辛酸泪");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas=baos.toByteArray();
        // 封装成 DatagramPacket包裹，需要指定目的地
        DatagramPacket packet;
        packet = new DatagramPacket(datas, datas.length,new InetSocketAddress("localhost",9999));
        //发送包裹send(DatagramPacket p)
        client.send(packet);
        //释放资源
        client.close();
    }
}
