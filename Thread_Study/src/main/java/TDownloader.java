/**
 *
 */
public class TDownloader extends Thread {
    private String url;//远程路径
    private String destPath;//存储

    public TDownloader(String url, String destPath) {
        this.url = url;
        this.destPath = destPath;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, destPath);
        System.out.println(destPath);
    }

    public static void main(String[] args) {
        Thread thread1=new TDownloader("https://cn.bing.com/th?id=OHR.FrenchColorado_ZH-CN9446885520_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp","lib/山.jpg");
        Thread thread2=new TDownloader("https://tvax1.sinaimg.cn/large/007Tv3Vmly1gcqhhfuyazj31hc0u0dov.jpg","lib/海.jpg");
        Thread thread3=new TDownloader("https://tvax1.sinaimg.cn/large/007Tv3Vmly1gcpaiilowrj31hc0u0dow.jpg","lib/熊.jpg");
       //启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
