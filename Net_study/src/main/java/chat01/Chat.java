package chat01;

import sun.misc.Cleaner;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * 在线聊天室：服务端
 */
public class Chat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------Server-----------");
        //1、指定端口
        ServerSocket server=null;
        try {
             server= new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2、阻塞式等待连接
        Socket socket=null;
        try {
             socket= server.accept();
            System.out.println("一个客户端建立了链接");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Socket> socketSet=new HashSet<>();
        socketSet.add(socket);
        //接收消息
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String datas=dataInputStream.readUTF();
        System.out.println(datas);

        //返回消息
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(datas);
        dataOutputStream.flush();
    }
}
