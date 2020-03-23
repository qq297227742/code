import java.io.*;

/**
 * 1、图片读取到字节数组、
 * 2、字节数组写出到文件
 */
public class IOTest09 {
    public static void main(String[] args) {
        byte[] temp = fileToByteArray("D:\\java\\code\\IO\\th.jpg");
        System.out.println(temp.length);
        byteArrayToFile(temp,"D:\\java\\code\\IO\\th2.jpg");
    }
    /**
     * 1、图片读取到字节数组
     * 1)、图片到程序 FileInputStream
     * 2)、程序到字节数组 ByteArrayOutputStream
     * @return
     */
    public static byte[] fileToByteArray (String filePath) {
        File src = new File(filePath);
        byte[] dest = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = new FileInputStream(src);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[]  flush=new byte[1024];//缓冲器
            int len = -1;
            while ((len = inputStream.read(flush)) != -1) {
                byteArrayOutputStream.write(flush, 0, len);//写出到字节数组中
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
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

        return null;
    }
    /**
     * 2、字节数组写出到文件
     * 字节数组读取到程序ByteArrayInputStream
     * 程序到文件 FileOutputStream
     */
    public static void byteArrayToFile(byte[] src,String filePath) {
        File dest = new File(filePath);
        OutputStream outputStream = null;
        try {
            outputStream=new FileOutputStream(dest);
            outputStream.write(src,0,src.length);
            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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

