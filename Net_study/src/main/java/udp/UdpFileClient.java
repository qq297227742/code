package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 *  1、使用DatagramSocket 创建发送端 指定端口
 *  2、准备数据 一定要转成字节数组
 *  3、封装成 DatagramPacket包裹，需要指定目的地
 *  4、发送包裹send(DatagramPacket p)
 *  5、释放资源
 */
public class UdpFileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。。");
        //使用DatagramSocket 创建发送端 指定端口
        DatagramSocket client=new DatagramSocket(8888) ;
        // 准备数据 一定要转成字节数组

        byte[] datas=IOUtils.fileToByteArray("th3.jpg");
        // 封装成 DatagramPacket包裹，需要指定目的地
        DatagramPacket packet;
        packet = new DatagramPacket(datas, datas.length,new InetSocketAddress("localhost",9999));
        //发送包裹send(DatagramPacket p)
        client.send(packet);
        //释放资源
        client.close();
    }
}
