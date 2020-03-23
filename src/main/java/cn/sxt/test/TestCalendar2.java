package cn.sxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar2 {
    public static void main(String[] args) {

        String string = "2020-10-10";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        date = new Date();
//        try {
//            date = dateFormat.parse(string);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        System.out.println("日\t一\t二\t三\t四\t五\t六");

        calendar.set(Calendar.DAY_OF_MONTH,1);

        for (int j = 1; j < calendar.get(Calendar.DAY_OF_WEEK); j++) {
            System.out.print("\t");
        }

        int maxDate = calendar.getActualMaximum(Calendar.DATE);//获取当月最大值

        for (int i = 1; i <= maxDate; i++) {
            System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");

            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
    }
}
