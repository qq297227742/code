package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

/**
 * 发送端：：使用面向对象封装
 */
public class TalkSend implements Runnable{
    private DatagramSocket socket;
    private BufferedReader reader;
    private byte[] datas;
    private String toIP;
    private int toPort;
    public TalkSend(int port,String toIP,int toPort) {
        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.toIP = toIP;
        this.toPort=toPort;
       reader=new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String data=null;
            try {
                data=reader.readLine();
                datas=data.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            DatagramPacket packet=new DatagramPacket(datas,datas.length, new InetSocketAddress(toIP,toPort));
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ("bye".equals(data)) {
                break;
            }
        }
        socket.close();

    }
}
