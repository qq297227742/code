import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载图片
 */
public class WebDownloader {
    public void downloader(String URL,String destPath)  {
        try {
            FileUtils.copyURLToFile(new URL(URL),new File(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
