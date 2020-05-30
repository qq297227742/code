package udp;

/**
 * 加入多线程，实现双向交流 模拟在线咨询
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999)).start();//接受
        new Thread(new TalkSend(5555,"localhost",8888)).start();//发送
    }
}
