package chat02;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类
 */
public class SxtUtils {
    public static void close(Closeable... targets) {
        for (Closeable target :
                targets) {
            try {

                if (target!=null) {
                    target.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
