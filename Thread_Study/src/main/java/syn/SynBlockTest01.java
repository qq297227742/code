package syn;

/**
 * 取钱
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 * @author weiwei
 */
public class SynBlockTest01 {

    public static void main(String[] args) {
        Account account=new Account(100,"结婚礼金");
        SynDrawing you=new SynDrawing(account,80,"可悲的你");
        SynDrawing  wife=new SynDrawing(account,90,"happy的她");
        you.start();
        wife.start();
    }
}

//账户


//模拟取款,线程安全
class SynDrawing extends Thread {
    Account account;
    int drawingMoney;
    int packetTotal;

    public SynDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }

    //目标锁定account

    public void test() {
        //提高效率
        if (account.money <= 0) {
            return;
        }
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(this.getName() + "--》账户余额为：" + account.money);
            System.out.println(this.getName() + "--》口袋的钱为：" + packetTotal);
        }
    }
}