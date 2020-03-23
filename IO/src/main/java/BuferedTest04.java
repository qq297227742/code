import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符缓冲流
 */
public class BuferedTest04 {
    public static void main(String[] args) {
        File dest=new File("C:\\java\\code\\IO\\src\\dest.txt");

        try (BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(dest))) {
            String msg = "IO is so easy";
            bufferedWriter.newLine();
            bufferedWriter.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
