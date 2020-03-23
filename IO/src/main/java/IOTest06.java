import java.io.*;

/**
 * 第一个程序；分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 * @author weiwei
 */
public class IOTest06 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File(System.getProperty("user.dir") + File.separator + "IO" + File.separator + "src"+File.separator+"dest.txt");
//        System.out.println(src.exists());

        //2、选择流
        Writer writer = null;
        try {
            writer= new FileWriter(src,true);
                //3、操作（写出）
            //写法一
            String msg = "IO is so easy\r\n 中国我爱你";
//            char[] datas = msg.toCharArray();
//            writer.write(datas,0,datas.length);

            //写法二
            writer.write(msg,0,msg.length());


            writer.append("山东").append("欢迎你");

            writer.flush();
            //4、释放资源

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
