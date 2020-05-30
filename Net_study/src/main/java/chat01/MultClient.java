package chat01;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：实现一个客户可以正常收发多条信息
 */
public class MultClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-------Client----------------");
        Socket clinet = new Socket("localhost", 8888);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(clinet.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(clinet.getInputStream());

        boolean isRunning = true;
        while (isRunning) {
            //发送消息
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();

            //接收消息
            String datas = dataInputStream.readUTF();
            System.out.println(datas);
        }
    }
}
