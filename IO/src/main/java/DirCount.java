import java.io.File;

/**
 * 使用面向对象：统计文件夹大小
 */
public class DirCount {
    private long len;
    private String dirPath;
    private File src;

    public DirCount() {
    }

    public DirCount(String dirPath) {
        this.dirPath = dirPath;
        this.src=new File(dirPath);
        count(src);
    }

    public static void main(String[] args) {
       DirCount dirCount=new DirCount(System.getProperty("user.dir"));
        System.out.println(dirCount.getLen());
    }



    private void count(File src) {
        if (src != null && src.exists()) {
            if (src.isFile()) {
                len += src.length();
            } else {
                for (File file :
                        src.listFiles()) {
                        count(file);
                }
            }
        }
    }

    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }
}
