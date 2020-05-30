package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端：使用面向对象封装
 */
public class TalkReceive implements Runnable{
    private DatagramSocket socket;

    public TalkReceive(int port ) {
        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] buffer = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String msg = new String(packet.getData(),0,packet.getLength());
            System.out.println(msg);
            if ("bye".equals(msg)) {
                break;
            }
        }
    }
}
