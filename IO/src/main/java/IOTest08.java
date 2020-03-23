import java.io.*;

/**
 * 字节数组输出流
 * 1、创建源：内部维护
 * 2、选择流：不关联源
 * 3、操作（写出内容）
 * 4、释放资源：可以不用处理
 * 获取数据：toByteArray()
 */
public class IOTest08 {
    public static void main(String[] args) {
        //1、创建源头
        byte[] dest = null;
        //2、选择流（新增方法）
        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            //3、操作（写出）
            String msg = "show me the code";
            byte[] datas = msg.getBytes();
            outputStream.write(datas,0,datas.length);
            outputStream.flush();

            //获取数据
            dest=outputStream.toByteArray();
            System.out.println(dest.length+"-->"+new String(dest,0,outputStream.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
