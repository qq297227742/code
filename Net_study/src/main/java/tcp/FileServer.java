package tcp;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *属性流程
 * 创建服务器
 * 1、使用ServerSocket创建服务器
 * 2、阻塞式的等待链接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        //1、使用ServerSocket创建服务器
        ServerSocket server=new ServerSocket(9999);
        // 2、阻塞式的等待链接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了链接");
        // 3、操作：输入输出流操作
        DataInputStream dataInputStream=new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("lib/copy.jpg"));
        byte[] data = new byte[1024];
        int len=-1;
        while ((len = dataInputStream.read(data)) != -1) {
            dos.write(data,0,len);
        }
        // 4、释放资源
        dataInputStream.close();
        client.close();
    }
}
