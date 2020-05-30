package others;

/**
 * 指令重排：代码的执行顺序与预期不一致
 * 目的：踢提高性能
 *
 * @author weiwei
 */
public class HappenBefore {
    //变量一
    private static int a = 0;
    //变量二
    private static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        //线程一 更改数据
        Thread t1=new Thread(()->{
            a=1;
            flag=true;
        });

        //线程二 读取数据
        Thread t2=new Thread(()->{
            if (flag) {
                a*=1;
            }
            //指令重排
            if (a == 0) {
                System.out.println("happen before->"+a);
            }
        });

        t1.start();
        t2.start();
        //合并线程 （插队）
        t1.join();
        t2.join();
    }
}
