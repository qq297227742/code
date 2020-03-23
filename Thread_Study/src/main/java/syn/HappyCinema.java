package syn;

/**
 * 快乐影院
 */
public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(2, "Happy Cinema");
        new Thread(new Customer(cinema,2),"lao").start();
        new Thread(new Customer(cinema,1),"pei").start();
    }
}


//顾客
class Customer implements Runnable {
Cinema cinema;
int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功 " + Thread.currentThread() + " 位置为 " + seats);
            } else {
                System.out.println("出票失败 " + Thread.currentThread() + " 位置不够 " + seats);
            }
        }
    }
}
class Cinema{
    int available;
    String name;

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }
    //购票
    public boolean bookTickets(int seats){
        System.out.println("可用位置为："+available);
        if (seats > available) {
            return false;
        }
        available-=seats;
        return true;
    }
}
