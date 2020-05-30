package tcp;

import java.io.*;
import java.net.Socket;

/**
 *属性流程
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
        //1、建立连接：使用Socket创建客户端+服务器的地址和端口
        Socket client = new Socket("localhost", 9999);
        //2、操作：输入输出流操作
        OutputStream outputStream = client.getOutputStream();
        DataInputStream dis=new DataInputStream (new FileInputStream("th3.jpg")); ;
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        byte[] data=new byte[1024];
        int len = -1;
        while ((len=dis.read(data))!=-1){
            dataOutputStream.write(data,0,len);
        }
        //3、释放资源
        dataOutputStream.close();
        client.close();

    }
}
