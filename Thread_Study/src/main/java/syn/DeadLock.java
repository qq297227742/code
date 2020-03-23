package syn;

/**
 * 死锁：过多的同步可能造成互相不释放资源
 * 从而互相等待，一一般发生与同步中持有多个对象的锁
 *
 * 避免：不要在同一个同步代码块中，同时持有多个对象的锁
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1=new Makeup(1, "大雅");
        Makeup g2=new Makeup(0, "小雅");
        g1.start();
        g2.start();
    }
}

//口红
class Liptick {

}

//镜子
class Mirror {

}

//化妆
class Makeup extends Thread {

    static Liptick liptick = new Liptick();
    static Mirror mirror = new Mirror();

    //选择
    int choice;
    //名字
    String girl;

    public Makeup(int choice,String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {

        //化妆
        makeup();

    }
    //相互持有对方的对象锁--》可能造成死锁
    private void makeup() {
        if (choice == 0) {
            synchronized (liptick) {//获得口红的锁
                System.out.println(this.girl + "获得口红");
                //1秒后 想拥有镜子的锁

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               /* synchronized (mirror) {//获得镜子的锁
                    System.out.println(this.girl + "获得镜子");
                }*/
            }
            synchronized (mirror) {//获得镜子的锁
                System.out.println(this.girl + "获得镜子");
            }
        } else {
            synchronized (mirror) {//获得镜子的锁
                System.out.println(this.girl+"获得镜子");
                //1秒后 想拥有镜子的锁

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*synchronized (liptick) {//获得口红的锁
                    System.out.println(this.girl+"获得口红");
                }*/
            }
            synchronized (liptick) {//获得口红的锁
                System.out.println(this.girl+"获得口红");
            }
        }
    }
}