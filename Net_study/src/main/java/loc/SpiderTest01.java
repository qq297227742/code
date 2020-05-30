package loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SpiderTest01 {
    public static void main(String[] args) throws IOException {
        //获取URL
        URL url=new URL("https://www.jd.com");
        //下载资源
        InputStream inputStream = url.openStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        String msg = null;
        while (null != (msg = reader.readLine())) {
            System.out.println(msg);
        }
        reader.close();
        //分析
        //处理
    }
}
