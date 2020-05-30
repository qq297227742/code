package others;

import java.util.*;

/**
 * 任务调度：Timer和TimerTask
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer=new Timer();
        //执行安排
       // timer.schedule(new MyTask(),1000);//执行任务一次
        //timer.schedule(new MyTask(),1000,200);//执行任务多次次
        Calendar calendar=new GregorianCalendar(2099,12,13,21,53,54);
        timer.schedule(new MyTask(),calendar.getTime(),200);//执行任务多次次

    }
}
//人物类
class MyTask extends TimerTask {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("放松大脑，休息一会儿");
        }
        System.out.println("----------------------end----------------");
    }
}