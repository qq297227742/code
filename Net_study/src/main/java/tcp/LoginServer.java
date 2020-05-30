package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *模拟登录 单项
 * 创建服务器
 * 1、使用ServerSocket创建服务器
 * 2、阻塞式的等待链接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {
        //1、使用ServerSocket创建服务器
        ServerSocket server=new ServerSocket(9999);
        // 2、阻塞式的等待链接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了链接");
        // 3、操作：输入输出流操作
        DataInputStream dataInputStream=new DataInputStream(client.getInputStream());
        String data = dataInputStream.readUTF();
        //分析数据
        String[] dataArray=data.split("&");
        for (String info:dataArray
             ) {
            String[] userInfo = info.split("=");
//            System.out.println(userInfo[0]+"----->"+userInfo[1]);
            if (userInfo[0].equals("uname")) {
                System.out.println("你的用户名为："+userInfo[1]);
            }else if (userInfo[0].equals("upwd")) {
                System.out.println("你的密码为："+userInfo[1]);
            }
        }
        System.out.println(data);
        // 4、释放资源
        dataInputStream.close();
        client.close();
    }
}
