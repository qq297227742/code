package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *模拟登录 多个客户端请求
 * 创建服务器
 * 1、使用ServerSocket创建服务器
 * 2、阻塞式的等待链接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 */
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
        //1、使用ServerSocket创建服务器
        ServerSocket server=new ServerSocket(9999);
        boolean isRunning=true;
        // 2、阻塞式的等待链接accept
        while (isRunning) {
            Socket client = server.accept();
            new Thread(new Channel(client)).start();
        }
    }
    static class Channel implements Runnable{
        private Socket client;
        private DataInputStream dataInputStream;
        private DataOutputStream dataOutputStream;
        public Channel(Socket client) {
            this.client = client;
            try {
                dataInputStream = new DataInputStream(client.getInputStream());
                dataOutputStream = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        @Override
        public void run() {
            System.out.println("一个客户端建立了链接");
            // 3、操作：输入输出流操作

           
            //分析数据
            String[] dataArray = receive().split("&");
            String uname = null;
            String upwd = null;
            for (String info : dataArray
            ) {
                String[] userInfo = info.split("=");
//            System.out.println(userInfo[0]+"----->"+userInfo[1]);
                if ("uname".equals(userInfo[0])) {
                    System.out.println("你的用户名为：" + userInfo[1]);
                    uname = userInfo[1];
                } else if ("upwd".equals(userInfo[0])) {
                    System.out.println("你的密码为：" + userInfo[1]);
                    upwd = userInfo[1];
                }
            }

            if ("shsxt".equals(uname) && "laopei".equals(upwd)) {
                send("登录成功");
            } else {
               send("用户名或密码错误！");
            }


            // 4、释放资源
            release();
        }
        private void send(String msg){
            try {
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private String receive(){
            String data=null;
            try {
                 data = dataInputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
        public void release(){
            try {
                if (dataInputStream!=null) {
                    dataInputStream.close();
                }
                if (dataOutputStream!=null) {
                    dataOutputStream.close();
                }
                if (client!=null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
