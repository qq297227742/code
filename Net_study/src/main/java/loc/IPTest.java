package loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:定位一个节点：计算机、路由、通信设备
 * InetAddress
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress add=InetAddress.getLocalHost();
        System.out.println(add.getHostAddress());
        System.out.println(add.getHostName());

        //根据域名得到InetAddress对象
        add = InetAddress.getByName("www.163.com");
        System.out.println(add.getHostAddress());
        System.out.println(add.getHostName());

        //根据IP得到InetAddress对象
        add = InetAddress.getByName("120.220.39.5");
        System.out.println(add.getHostAddress());
        System.out.println(add.getHostName());
    }
}
