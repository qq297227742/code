import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 复制内容
 */
public class CIOTest05 {
    public static void main(String[] args) throws IOException {
      //复制文件
//        FileUtils.copyFile(new File("C:\\java\\code\\IO\\th.jpg"),new File("th3.jpg") );
        //复制文件到目录
//        FileUtils.copyFileToDirectory(new File("C:\\java\\code\\IO\\th.jpg"), new File("lib"));
        // 复制目录到目录
//        FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
        //复制目录
//        FileUtils.copyDirectory(new File("lib"), new File("lib2"));
        // 拷贝URL内容
//        String url="https://cn.bing.com/th?id=OHR.SiestaKey_ZH-CN1759696989_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp";
//        FileUtils.copyURLToFile(new URL(url),new File("lib/hp.jpg") );
        //
        String string = IOUtils.toString(new URL("https://www.baidu.com"), "UTF-8");
        System.out.println(string);
        //
    }

}
