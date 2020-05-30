package chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * 在线聊天室：服务端
 * 目标：实现一个客户可以正常收发多条信息
 */
public class TMultiChat {
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
        while (true) {
            try {
                socket = server.accept();
                System.out.println("一个客户端建立了链接");
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(new Channel(socket)).start();
        }

    }
    static class Channel implements Runnable{
        private boolean isRunning;
        private  DataInputStream dataInputStream;
        private  DataOutputStream dataOutputStream;
        private Socket client;

        public Channel(Socket client) {
            this.client = client;
            isRunning=true;
            try {
                dataInputStream = new DataInputStream(client.getInputStream());
                dataOutputStream=new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                release();
                e.printStackTrace();
            }
        }

        private String receive(){
            String msg = "";
            try {
                msg=dataInputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                release();
                isRunning=false;
            }
            return msg;
        }
        private void send(String msg){
            try {
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }
        private void release(){
            SxtUtils.close(dataInputStream,dataOutputStream,client);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                System.out.println(client+msg);
                send(msg);
            }

        }
    }
}
