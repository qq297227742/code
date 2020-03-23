import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * 大小
 */
public class CIOTest01 {
    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("C:\\java\\code\\IO\\src\\main\\java\\CIOTest01.java"));
        System.out.println(len);
        //目录大小
        len = FileUtils.sizeOf(new File("C:\\java\\code"));
        System.out.println(len);
    }
}
