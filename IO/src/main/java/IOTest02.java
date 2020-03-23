import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 第一个程序；理解步骤 标准
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author weiwei
 */
public class IOTest02 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File(System.getProperty("user.dir") + File.separator + "IO" + File.separator + "src"+File.separator+"abc.txt");
//        System.out.println(src.exists());

        //2、选择流
        InputStream inputStream = null;
        try {
            inputStream= new FileInputStream(src);
                //3、操作（读取）
            int temp;
            while ((temp = inputStream.read())!=-1) {
                System.out.println((char) temp);
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
