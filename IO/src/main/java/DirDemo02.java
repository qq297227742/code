import java.io.File;

/**
 * 列出下一级
 * 1、list()：列出下级名称
 * 2、listFiles()：列出下级File对象
 *
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.dir"));
        System.out.println(dir);
        
        //列出下级名称
        String[] subName = dir.list();
        for (String s :
                subName) {
            System.out.println(s);
        }

        //下级对象
        File[] listFiles = dir.listFiles();
        for (File f :
                listFiles) {
            System.out.println(f);
        }

        //所有盘符
        File[] roots=dir.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }
    }

}
