package chat02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端接收
 */
public class Receive implements Runnable {
    private Socket client;
    private DataInputStream dataInputStream;
    private boolean isRunning;

    public Receive(Socket client) {
        this.client = client;
        try {
            dataInputStream=new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        isRunning=true;
    }
    private String receive(){
        String msg="";
        try {
            msg = dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
    @Override
    public void run() {
        while (isRunning) {
            String msg=receive();
            System.out.println(msg);
            if ("bye".equals(msg)) {
                isRunning=false;
            }
        }
        release();
    }
    private void release(){
        SxtUtils.close(dataInputStream,client);
    }
}
