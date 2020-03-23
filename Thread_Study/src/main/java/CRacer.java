import java.util.concurrent.*;

/**
 * 模拟龟兔赛跑
 */
public class CRacer implements Callable<Integer> {
    private static String winner;//胜利者
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            boolean flag=gameOver(i);
            if (flag) {
                return i;
            }
        }
        return null;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();
        //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> future1=executorService.submit(racer);
        Future<Integer> future2=executorService.submit(racer);

        //获取结果
        Integer r1 = future1.get();
        Integer r2 = future2.get();
        System.out.println(r1+"-->"+r2);

        //关闭服务
        executorService.shutdownNow();
    }


}
