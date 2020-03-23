package syn;

/**
 *买票
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 */
public class SynTest01 {
    public static void main(String[] args) {
        //一份资源
        SafeWeb12306 web=new SafeWeb12306();

        //多个代理
        new Thread(web).start();
        new Thread(web).start();
        new Thread(web).start();
    }
}

class SafeWeb12306 implements Runnable{
    private int ticket=10;
    private boolean falg = true;
    @Override
    public void run() {

        while (falg) {
            test();
        }
    }
    //线程安全 同步
    public synchronized void test() {
        if (ticket <= 0) {
            falg=false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticket--);
    }
}