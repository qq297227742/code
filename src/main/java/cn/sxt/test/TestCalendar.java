package cn.sxt.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试日期类的使用
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar=new GregorianCalendar(2999,10,9,22,10,50);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);//0：一月；
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);//周几；1：周日；2：周一
        System.out.println(weekday);



        System.out.println(calendar);


        //设置日期
        Calendar c2 = new GregorianCalendar();
        c2.set(Calendar.YEAR, 2222);

        System.out.println(c2);

        //日期的计算
        Calendar c3 = new GregorianCalendar();
        c3.add(Calendar.YEAR, -100);

        System.out.println(c3);

        //日期对象和时间对象的转换
        Date date = c3.getTime();
        Calendar c4 = new GregorianCalendar();
        c3.setTime(new Date());

    }
}
