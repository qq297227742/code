import java.io.File;

/**
 * 创建目录
 * 1、mkdir()：确保上级目录存在，不存在则创建失败
 * 2、mkdirs()：上级目录可以不存在，不存在的一同创建
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("D:\\java\\code\\IO\\dir\\test");
        //创建目录
        boolean flag = dir.mkdir();
        System.out.println(flag);
    }

}
