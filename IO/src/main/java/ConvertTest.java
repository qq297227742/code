import java.io.*;

/**
 * 转换流：InputStreamReader OutputStreamWriter
 * 1、以字符集的形式操作字节流（纯文本）
 * 2、指定字符集
 */
public class ConvertTest {
    public static void main(String[] args) {
        //操作System.in System.out
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))){

            //获取键盘的输入，答应此内容
            String msg = "";
            while (!msg.equals("exit")) {
                msg = bufferedReader.readLine();
                bufferedWriter.write(msg);
                bufferedWriter.newLine();
                bufferedWriter.flush();//强制刷新
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("操作异常");
        }

    }

}
