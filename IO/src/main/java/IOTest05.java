import java.io.*;

/**
 * 文件字符输入流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author weiwei
 */
public class IOTest05 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File(System.getProperty("user.dir") + File.separator + "IO" + File.separator + "src"+File.separator+"abc.txt");
//        System.out.println(src.exists());

        //2、选择流
        Reader reader = null;
        try {
            reader= new FileReader(src);
                //3、操作
            char[] datas = new char[1024];
            int len = -1;
            while ((len = reader.read(datas))!=-1) {
                String string = new String(datas, 0, len);
                System.out.println(string);
            }
            //4、释放资源

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader!=null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
