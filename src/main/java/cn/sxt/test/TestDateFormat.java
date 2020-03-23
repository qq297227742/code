package cn.sxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的相互转换
 * DateFormat
 * SimpleDateFormat
 */
public class TestDateFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String string = df.format(new Date());//时间转 字符串
        System.out.println(string);

        try {
            Date date = df.parse("1983-10-10 11:45:59");//字符串转换到时间
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //测试其他
        //年中的天数
        DateFormat dateFormat = new SimpleDateFormat("D");
        String string2 = dateFormat.format(new Date());
        System.out.println(string2);
    }
}
