import java.io.*;

/**
 * 第一个程序
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author weiwei
 */
public class IOTest01 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File(System.getProperty("user.dir") + File.separator + "IO" + File.separator + "src"+File.separator+"abc.txt");
//        System.out.println(src.exists());
        //2、选择流
        try {
            InputStream inputStream = new FileInputStream(src);
                //3、操作（读取）
                int read = inputStream.read();//第一个数据 h
                int read2 = inputStream.read();//第一个数据 e
                int read3 = inputStream.read();//第一个数据 l
            //文件末尾返回-1
            System.out.println((char) read);
            System.out.println((char) read2);
            System.out.println((char) read3);
            //4、释放资源
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
