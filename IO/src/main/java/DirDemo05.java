import com.sun.javaws.IconUtil;

import java.io.File;

/**
 * 递归：方法自己调用自己
 * 打印子孙级目录和文件的名称
 * 统计文件夹大小
 */
public class DirDemo05 {
    public static void main(String[] args) {
        File src=new File(System.getProperty("user.dir"));
        count(src);
        System.out.println(len);
    }

    private static long len;
    public static void count(File src) {

        //获取大小
        if (src!= null && src.exists()) {
            if (src.isFile()) {//大小
                   len+= src.length();
            } else {//子孙级
                for (File s :
                        src.listFiles()) {
                    count(s);
                }
            }
        }
    }
}
