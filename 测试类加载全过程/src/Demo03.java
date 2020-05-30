/**
 * 测试自定义的FileSystemClassLoader
 */
public class Demo03 {
    public static void main(String[] args) {

        FileSystemClassLoader loader = new FileSystemClassLoader("c:/myjava");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("c:/myjava");
        try {
            Class<?> c = loader.loadClass("HelloWorld");
            Class<?> c2 = loader.loadClass("HelloWorld");
            Class<?> c3 = loader2.loadClass("HelloWorld");

            System.out.println(c.hashCode());
            System.out.println(c2.hashCode());
            System.out.println(c3.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
