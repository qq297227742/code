import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组输入流
 * 1、创建源：字节数组不要太大
 * 2、选择流
 * 3、操作
 * 4、释放资源：可以不用处理
 */
public class IOTest07 {
    public static void main(String[] args) {
        //1、创建源头
        byte[] src = "talk is cheap show me the code".getBytes();
        //2、选择流
        InputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(src);
            //3、操作
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = inputStream.read(flush)) != -1) {
                String string = new String(flush, 0, len);
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
