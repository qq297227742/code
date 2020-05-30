package udp;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * 1、使用DatagramSocket 创建接收端 指定端口
 * 2、准备容器 封装成 DatagramPacket包裹
 * 3、阻塞式接受包裹receive(DatagramPacket p)
 * 4、分析数据
 * byte[]    getData()
 * int       getLength()
 * 5、释放资源
 */
public class UdpServer {
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
        byte[] datas = packet.getData();
        int len=packet.getLength();
        System.out.println(new String(datas,0,len));
        // int       getLength()
        //5、释放资源
        server.close();
    }
}
