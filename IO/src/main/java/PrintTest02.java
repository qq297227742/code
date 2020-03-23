import java.io.*;

/**
 * 打印流
 * PrintWriter
 */
public class PrintTest02 {
    public static void main(String[] args) throws FileNotFoundException {


        PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
        printWriter.println("打印流");
        printWriter.println(true);


        printWriter.close();
    }
}
