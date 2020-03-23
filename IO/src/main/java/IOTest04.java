import java.io.*;

/**
 * 第一个程序；分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 * @author weiwei
 */
public class IOTest04 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File(System.getProperty("user.dir") + File.separator + "IO" + File.separator + "src"+File.separator+"dest.txt");
//        System.out.println(src.exists());

        //2、选择流
        OutputStream outputStream = null;
        try {
            outputStream= new FileOutputStream(src,true);
                //3、操作（写出）
            String msg = "IO is so easy";
            byte[] datas = msg.getBytes();
            outputStream.write(datas,0,datas.length);
            outputStream.flush();
            //4、释放资源

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(outputStream!=null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
