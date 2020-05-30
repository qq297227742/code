package chat01;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：实现一个客户可以正常收发信息
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-------Client----------------");
        Socket clinet = new Socket("localhost", 8888);
        //发送消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String msg=console.readLine();
        DataOutputStream dos = new DataOutputStream(clinet.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();

        //接收消息
        DataInputStream dataInputStream = new DataInputStream(clinet.getInputStream());
        String datas=dataInputStream.readUTF();
        System.out.println(datas);
    }
}
