import java.util.concurrent.*;

public class CDownloader implements Callable<Boolean> {
    private String url;
    private String destPath;

    public CDownloader(String url, String destPath) {
        this.url = url;
        this.destPath = destPath;
    }


    @Override
    public Boolean call() throws Exception {
        WebDownloader wd=new WebDownloader();
        wd.downloader(url,destPath);
        return true;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程
        CDownloader cDownloader1=new CDownloader("https://cn.bing.com/th?id=OHR.FrenchColorado_ZH-CN9446885520_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp","lib/山.jpg");
        CDownloader cDownloader2=new CDownloader("https://tvax1.sinaimg.cn/large/007Tv3Vmly1gcqhhfuyazj31hc0u0dov.jpg","lib/海.jpg");
        CDownloader cDownloader3=new CDownloader("https://tvax1.sinaimg.cn/large/007Tv3Vmly1gcpaiilowrj31hc0u0dow.jpg","lib/熊.jpg");
        //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> future1=executorService.submit(cDownloader1);
        Future<Boolean> future2=executorService.submit(cDownloader2);
        Future<Boolean> future3=executorService.submit(cDownloader3);
        //获取结果
        boolean r1 = future1.get();
        boolean r2 = future2.get();
        boolean r3 = future3.get();
        System.out.println(r3);
        //关闭服务
        executorService.shutdownNow();
    }

}