/**
 *创建线程方式二
 * 1、创建：实现Runnable 重写run
 * 2、启动：创建Thread对象 start
 *
 * 推荐：避免单继承的局限性，有限使用接口
 * 方便共享资源
 *
 */
public class StarRun {



    public static void main(String[] args) {
        //创建线程
        Thread thread1=new Thread(new IDownloader("https://cn.bing.com/th?id=OHR.FrenchColorado_ZH-CN9446885520_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp","lib/山.jpg"));
        Thread thread2=new Thread(new IDownloader("https://tvax1.sinaimg.cn/large/007Tv3Vmly1gcqhhfuyazj31hc0u0dov.jpg","lib/海.jpg"));
        Thread thread3=new Thread(new IDownloader("https://tvax1.sinaimg.cn/large/007Tv3Vmly1gcpaiilowrj31hc0u0dow.jpg","lib/熊.jpg"));
        //启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }


}

class IDownloader implements Runnable {
    private String url;
    private String destPath;

    public IDownloader(String url, String destPath) {
        this.url = url;
        this.destPath = destPath;
    }

    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,destPath);
    }
}