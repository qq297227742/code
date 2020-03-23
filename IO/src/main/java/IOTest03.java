import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 第一个程序；分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author weiwei
 */
public class IOTest03 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File(System.getProperty("user.dir") + File.separator + "IO" + File.separator + "src"+File.separator+"abc.txt");
//        System.out.println(src.exists());

        //2、选择流
        InputStream inputStream = null;
        try {
            inputStream= new FileInputStream(src);
                //3、操作（分段读取）
            byte[] flush=new byte[1024];//缓冲容器
            int len = -1;//接收长度
            while ((len = inputStream.read(flush))!=-1) {
                //字节数组--》字符串（解码）
                String string = new String(flush, 0, len);
                System.out.println(string);
            }

            //4、释放资源
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream!=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
