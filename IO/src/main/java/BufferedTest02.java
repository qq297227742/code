import java.io.*;

/**
 * 文件输出流 加入缓冲流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class BufferedTest02 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("C:\\java\\code\\IO\\src\\dest.txt");
        //2、选择流
        OutputStream outputStream = null;
//        BufferedInputStream bufferedInputStream = null;

        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(src));
            //bufferedInputStream=new BufferedInputStream(outputStream);
            String msg = "IO is so easy\r\n";
            byte[] flush = msg.getBytes();

           outputStream.write(flush,0,flush.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream!=null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
