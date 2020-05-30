package tcp;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.*;
import java.net.Socket;

/**
 *模拟登录 多个客户端请求
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 */
public class LoginMultiClient {
    public static void main(String[] args) throws IOException {
        //1、建立连接：使用Socket创建客户端+服务器的地址和端口
        Socket client = new Socket("localhost", 9999);

        //2、操作：输入输出流操作
       new Send(client).send();
       String msg=new Receive(client).recevie();
        System.out.println(msg);
        //3、释放资源
        client.close();

    }
    static class Send{
        private DataOutputStream dataOutputStream;
        private Socket client;
        private BufferedReader console;
        private String msg;
        public Send(Socket client) {
            this.client=client;
            console = new BufferedReader(new InputStreamReader(System.in));
            msg=init();
            try {
                this.dataOutputStream = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private String init(){
            try {
                System.out.println("请输入用户名：");
                String uname=console.readLine();
                System.out.println("请输入密码：");
                String upwd=console.readLine();
                return"uname="+uname+"&upwd="+upwd;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
        public void send(){
            try {
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static class Receive{
        private DataInputStream dataInputStream;
        private Socket client;

        public Receive(Socket client) {
            this.client = client;
            try {
                this.dataInputStream=new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public String recevie(){
            String msg=null;
            try {
                msg= dataInputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return msg;
        }
    }
}
