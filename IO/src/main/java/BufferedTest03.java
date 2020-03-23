import java.io.*;


/**
 * 字符缓冲流
 */
public class BufferedTest03 {
    public static void main(String[] args) {
        File src = new File("C:\\java\\code\\IO\\src\\abc.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(src));

            String line=null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
