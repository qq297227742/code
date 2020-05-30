package others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS：比较并交换
 *
 *
 */
public class CAS {
    //库存
    private static AtomicInteger stock=new AtomicInteger(5);
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                //模拟延迟
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Integer left = stock.decrementAndGet();
                if (left < 1) {
                    System.out.println("抢完了。。。");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "抢了一个商品。。");
                System.out.println("还剩下"+left);
            }).start();
        }
    }
}
