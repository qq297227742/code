package chat02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端发送
 */
public class Send implements Runnable {
    private Socket client;
    private DataOutputStream dataOutputStream;
    private BufferedReader reader;
    private boolean isRunning;

    public Send(Socket client) {
        this.client = client;
        try {
            dataOutputStream = new DataOutputStream(client.getOutputStream());
            reader=new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        isRunning=true;
    }
    private String getMsgFromComsole() {
        String msg = "";
        try {
            msg = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
    private void send(String msg){
        try {
            dataOutputStream.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @Override
    public void run() {
        while (isRunning){
           String msg=getMsgFromComsole();
           send(msg);
            if ("bye".equals(msg)) {
                isRunning=false;
            }
        }
        release();
    }
    private void release(){
        SxtUtils.close(reader,dataOutputStream,client);
    }
}
