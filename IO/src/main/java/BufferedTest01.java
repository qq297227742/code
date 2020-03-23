import java.io.*;

/**
 * 文件输入流 加入缓冲流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class BufferedTest01 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("C:\\java\\code\\IO\\src\\abc.txt");
        //2、选择流
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            inputStream = new BufferedInputStream(new FileInputStream(src));
            //bufferedInputStream=new BufferedInputStream(inputStream);
            byte[] flush = new byte[1024];//缓冲容器
            int len=-1;
            while ((len = inputStream.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream!=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
