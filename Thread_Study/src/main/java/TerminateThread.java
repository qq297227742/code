/**
 * 终止线程
 * 1、线程正常执行完毕--》次数
 * 2、外部干涉--》加入标识
 */
public class TerminateThread implements Runnable{

    //加入标识标记线程体是否可以运行
    private boolean flag=true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        //关联标识
        while (flag) {
            System.out.println(name+"-->"+i++);
        }
    }
    public void terinate() {
        this.flag = false;
    }


    public static void main(String[] args) {

        TerminateThread tt = new TerminateThread("sss");
        new Thread(tt).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main-->"+i);
            if (i == 88) {
                tt.terinate();
                System.out.println("ganme over");
            }
        }
    }
}
