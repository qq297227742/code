/**
 *线程上下文类加载器的测试
 */
public class Demo05 {
    public static void main(String[] args) {

        ClassLoader loader = Demo05.class.getClassLoader();
        System.out.println(loader);

        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader2);

        Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("c:/myjava/"));
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
