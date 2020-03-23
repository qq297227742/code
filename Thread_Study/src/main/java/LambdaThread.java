/**
 *
 * Lambda表达式，简化线程的使用（用一次）
 */
public class LambdaThread {
    //静态内部类
    static class Test implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("listenning Song");
            }
        }
    }
    public static void main(String[] args) {
       // new Thread(new Test()).start();

        //局部内部类
        class Test2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("listenning Song");
                }
            }
        }
        new Thread(new Test2()).start();

        //匿名内部类，必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 12; i++) {
                    System.out.println("coding");
                }
            }
        }).start();

        //jdk8 简化 Lambda
        new Thread(()->{
            for (int i = 0; i < 12; i++) {
                System.out.println("lambda");
            }
        }).start();
    }
}
