import java.io.File;

/**
 * 递归：方法自己调用自己
 * 递归头：何时结束递归
 * 递归体：重复调用
 */
public class DirDemo03 {
    public static void main(String[] args) {
        showFiles(new File(System.getProperty("user.dir")));
    }

    public static void showFiles(File file) {
        System.out.println(file);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f :
                    files) {
                showFiles(f);
            }
        }
    }
}
