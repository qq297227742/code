/**
 * 共享资源,并发（线程安全）
 */
public class Web12306 implements Runnable {
    private int ticket=100;
    @Override
    public void  run() {
        while (true) {
            if (ticket < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticket--);


        }
    }

    public static void main(String[] args) {
        //一份资源
        Web12306 ticket=new Web12306();
        //多个代理
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
