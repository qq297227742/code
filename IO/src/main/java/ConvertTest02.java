import java.io.*;
import java.net.URI;
import java.net.URL;

/**
 * 转换流：InputStreamReader OutputStreamWriter
 * 1、以字符集的形式操作字节流（纯文本）
 * 2、指定字符集
 */
public class ConvertTest02 {
    public static void main(String[] args) {
        //操作网络流 下载百度的源代码
        try(BufferedReader bufferedReader=
                    new BufferedReader(
                        new InputStreamReader(
                            new URL("http://www.baidu.com").openStream(),"UTF-8"));
            BufferedWriter bufferedWriter=
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream("baidu.html"),"UTF-8"));) {
            String msg = null;
            while((msg =bufferedReader.readLine())!=null) {
//                System.out.print(msg);
                bufferedWriter.write(msg);//字符集不统一
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("操作异常");
        }

    }
    public static void test2(){
        //操作网络流 下载百度的源代码
        try(InputStreamReader inputStream=new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8")) {

            int temp;
            while((temp =inputStream.read())!=-1)
            {
                System.out.print((char) temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("操作异常");
        }
    }
    public static void test1() {
        //操作网络流 下载百度的源代码
        try(InputStream inputStream=new URL("https://www.baidu.com").openStream()){
            int temp;
            while ((temp = inputStream.read()) != -1) {
                System.out.print((char)temp);//字节数不够出现乱码
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("操作异常");
        }

    }

}
