import java.io.*;

/**
 * 数据流
 * 1、先写出后读取
 * 2、读取的顺序与写出的保持一致
 *
 * DataOutputStream
 * DataInputStream
 */
public class DataTest {
    public static void main(String[] args) throws IOException {
        //写出
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));
            //操作数据类型+数据
        dataOutputStream.writeUTF("编码辛酸泪");
        dataOutputStream.writeInt(18);
        dataOutputStream.writeBoolean(false);
        dataOutputStream.writeChar('a');
        dataOutputStream.flush();
        byte[] datas = byteArrayOutputStream.toByteArray();
        System.out.println(datas.length);
        //读取
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一致
        String string;
        string = dataInputStream.readUTF();
        int int1 = dataInputStream.readInt();
        boolean flag = dataInputStream.readBoolean();
        char c = dataInputStream.readChar();

        System.out.println(string+int1+flag+c);
    }
}
