package loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpiderTest02 {
    public static void main(String[] args) throws IOException {
        //获取URL
        URL url=new URL("https://www.dianping.com");
        //下载资源
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
        BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String msg = null;
        while (null != (msg = reader.readLine())) {
            System.out.println(msg);
        }
        reader.close();
        //分析
        //处理
    }
}
