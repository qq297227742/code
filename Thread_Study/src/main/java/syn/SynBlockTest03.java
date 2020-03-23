package syn;

/**
 *买票
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 */
public class SynBlockTest03 {
    public static void main(String[] args) {
        //一份资源
        SynWeb12306 web=new SynWeb12306();

        //多个代理
        new Thread(web,"码农").start();
        new Thread(web,"码畜").start();
        new Thread(web,"码蟥").start();
    }
}

class SynWeb12306 implements Runnable{
    private int ticket=10;
    private boolean falg = true;
    @Override
    public void run() {

        while (falg) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test5();
        }
    }

    //线程安全
    //尽可能锁定合理的范围
    //不是指代码，是数据的完整性
    public void test5() {
        if (ticket <= 0) {//考虑的是没有票的情况
            falg = false;
            return;
        }
        synchronized (this) {
            if (ticket <= 0) {//考虑的是最后一张票
                falg = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticket--);
        }

    }

    //线程不安全
    //范围太小，锁不住
    public  void test4() {
        synchronized (this) {
            if (ticket <= 0) {
                falg = false;
                return;
            }
        }

        try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticket--);

    }


//线程不安全
    //ticket对象在变
    public  void test3() {
        synchronized ((Integer)ticket) {
            if (ticket <= 0) {
                falg = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticket--);
        }

    }


    //同步块
    //线程安全，范围太大--》效率低下
    public  void test2() {
        synchronized (this) {
            if (ticket <= 0) {
                falg = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticket--);
        }

    }
    //线程安全 同步
    public synchronized void test1() {
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