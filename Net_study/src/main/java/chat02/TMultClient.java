package chat02;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：实现一个客户可以正常收发多条信息
 */
public class TMultClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-------Client----------------");
        Socket clinet = new Socket("localhost", 8888);
        new Thread(new Send(clinet)).start();
        new Thread(new Receive(clinet)).start();
    }
}
