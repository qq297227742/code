package others;

/**
 * volatile用于保证数据的同步，可见性
 */
public class VolatileTest {
    public static volatile int number = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (number == 0) {

            }
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number=1;
    }

}
