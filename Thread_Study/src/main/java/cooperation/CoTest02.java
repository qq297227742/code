package cooperation;
/**
 * 写作模型：生产者消费者实现方式一：信号灯法
 * 借助标志位
 */
public class CoTest02 {
    public static void main(String[] args) {
        Tv tv=new Tv();
        new Player(tv).start();
        new Watcher(tv).start();

    }
}

//生产者 演员
class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.play("表演了第"+i+"次");
        }
    }
}
//消费者 观众
class Watcher extends Thread {
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
//同一个资源 电视
class Tv {
    String voice;
    //信号灯
    //T 演员表演 观众等待
    boolean flag=true;

    //表演
    public synchronized void play(String voice) {
        //演员等待
        if (flag==false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了："+voice);
        this.voice = voice;
        flag=false;
        notifyAll();
    }
    //观看
    public synchronized void watch() {
        if (flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了："+voice);
        flag = true;
        notifyAll();
    }
}
