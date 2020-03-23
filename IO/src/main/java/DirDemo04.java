import java.io.File;

/**
 * 递归：方法自己调用自己
 * 打印子孙级目录和文件的名称
 */
public class DirDemo04 {
    public static void main(String[] args) {
        File src=new File(System.getProperty("user.dir"));
        printName(src,0);
    }

    //打印子孙及目录和文件名称
    public static void printName(File src,int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("-");
        }
        System.out.println(src);
        if (null == src || !src.exists()) {
            return;
        } else if (src.isDirectory()) {
            for (File s : src.listFiles()) {
                printName(s,deep+1);
            }
        }
    }
}
