package tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *属性流程
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1、建立连接：使用Socket创建客户端+服务器的地址和端口
        Socket client = new Socket("localhost", 9999);
        //2、操作：输入输出流操作
        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        String data="Hello";
        dataOutputStream.writeUTF(data);
        dataOutputStream.flush();
        //3、释放资源
        dataOutputStream.close();
        client.close();

    }
}
