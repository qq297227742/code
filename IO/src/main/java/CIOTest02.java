import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * 子孙级
 */
public class CIOTest02 {
    public static void main(String[] args) {


        Collection<File> files = FileUtils.listFiles(new File("C:\\java\\code"), EmptyFileFilter.NOT_EMPTY, null);
        for (File file :
                files) {
            System.out.println(file);
        }
        System.out.println("-----------------------------------");

        files = FileUtils.listFiles(new File("C:\\java\\code"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for (File file :
                files) {
            System.out.println(file);
        }

        System.out.println("-----------------------------------");

        files = FileUtils.listFiles(new File("C:\\java\\code"),
                new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
        for (File file :
                files) {
            System.out.println(file);
        }

        System.out.println("-----------------------------------");

        files = FileUtils.listFiles(new File("C:\\java\\code"),
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
        for (File file :
                files) {
            System.out.println(file);
        }

        System.out.println("-----------------------------------");

        files = FileUtils.listFiles(new File("C:\\java\\code"),
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
        for (File file :
                files) {
            System.out.println(file);
        }
    }
}
