package syn;

/**
 *买票
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        //一份资源
        UnsafeWeb12306 web=new UnsafeWeb12306();

        //多个代理
        new Thread(web).start();
        new Thread(web).start();
        new Thread(web).start();
    }
}
class UnsafeWeb12306 implements Runnable{
    private int ticket=10;
    private boolean falg = true;
    @Override
    public void run() {

        while (falg) {
            test();
        }
    }
    public  void test() {
        if (ticket < 0) {
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