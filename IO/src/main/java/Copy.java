import org.w3c.dom.CDATASection;

import java.io.*;

/**
 * 文件拷贝：文件字节输入、输出流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class Copy {
    public static void main(String[] args) {
//        File src = new File(System.getProperty("user.dir") + File.separator + "IO" + File.separator + "src" + File.separator + "abc.txt");
//        File dest = new File(System.getProperty("user.dir") + File.separator + "IO" + File.separator + "src"+File.separator+"dest.txt");
        /*long t1 = System.currentTimeMillis();
        copy2("C:\\java\\code\\IO\\th.jpg","C:\\java\\code\\IO\\thcopy.jpg");
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

         t1 = System.currentTimeMillis();
        copyBuffered("C:\\java\\code\\IO\\th.jpg","C:\\java\\code\\IO\\thcopy.jpg");
         t2 = System.currentTimeMillis();
        System.out.println(t2-t1);*/

        long t1 = System.currentTimeMillis();
        charCopyBuffered("C:\\java\\code\\IO\\src\\abc.txt","C:\\java\\code\\IO\\src\\dest.txt");
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    public static void copy(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        InputStream inputStream=null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(dest,true);
            byte[] datas = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(datas)) != -1) {
                outputStream.write(datas,0,len);
            }
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
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copy2(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);

        try (InputStream inputStream = new FileInputStream(src); OutputStream outputStream = new FileOutputStream(dest)) {
            byte[] datas = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(datas)) != -1) {
                outputStream.write(datas, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copyBuffered(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(src));
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] datas = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(datas)) != -1) {
                outputStream.write(datas, 0, len);
            }

        } catch(FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void charCopyBuffered(String srcPath, String destPath) {
        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(srcPath));BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(destPath))){
           String string=null;
            while ((string = bufferedReader.readLine()) != null) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
