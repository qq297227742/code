/**
 * 模拟龟兔赛跑
 */
public class Racer implements Runnable {
    private static String winner;//胜利者
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            boolean flag=gameOver(i);
            if (flag) {
                break;
            }
        }
    }
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner"+"--"+winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "tortoise").start();
        new Thread(racer, "rabbit").start();
    }
}
