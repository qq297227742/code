package tcp;

import java.io.*;
import java.net.Socket;

/**
 *模拟登录 单项
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        //1、建立连接：使用Socket创建客户端+服务器的地址和端口
        Socket client = new Socket("localhost", 9999);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String uname=console.readLine();
        System.out.println("请输入密码：");
        String upwd=console.readLine();
        //2、操作：输入输出流操作
        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);




        dataOutputStream.writeUTF("uname="+uname+"&upwd="+upwd);
        dataOutputStream.flush();
        //3、释放资源
        dataOutputStream.close();
        client.close();

    }
}
