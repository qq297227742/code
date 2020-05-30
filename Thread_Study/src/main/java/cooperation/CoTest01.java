package cooperation;

/**
 * 写作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread {
    SynContainer container;
    Consumer consumer;

    public Productor(SynContainer container) {
        this.container = container;
        //this.consumer=consumer;
    }

    @Override
    public void run() {
        //开始生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产--》第"+i+"个馒头");
            container.push(new Steamedbun(i));
          /*  if (container.getCount() < 10) {
                container.push(new Steamedbun(i));
            } else {
                try {
                    wait();
                    consumer.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;
    Productor productor;
    public Consumer(SynContainer container) {
        this.container = container;
      //  this.productor = productor;
    }

    @Override
    public void run() {
        //消费
        for (int i = 0; i < 1000; i++) {
            System.out.println("消费《--第"+container.pop().id+"个馒头");
           /* if (container.getCount()>0) {
                container.pop();
            }else {
                try {
                    wait();
                    productor.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }

    }
}

//缓冲区
class SynContainer {
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;
    //存 生产
    public synchronized void push(Steamedbun bun) {
        // 何时生产 容器存在空间

        if (count == buns.length) {
            try {
                wait();//线程阻塞    消费者通知生产 解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间
        buns[count] = bun;
        this.notifyAll();//存在数据了，可以唤醒对方消费了
        count++;
    }

    //取  消费
    public synchronized Steamedbun pop() {
        //何时消费 容器中是否存在数据
        //没有数据 等待
        if (count ==0 ) {
            try {
                wait();//线程阻塞    生产者通知消费 解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据
        count--;
        Steamedbun bun = buns[count];
        this.notifyAll();//存在空间了，可以唤醒对方生产了
        return bun;
    }

    public int getCount() {
        return count;
    }
}

//数据（馒头）
class Steamedbun {
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}