import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        int result=compiler.run(null, null, null, "c:/myjava/HelloWorld.java");
        System.out.println(result==0?"编译成功":"编译失败");

        //通过Runtime调用执行类
       /* Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp c:/myjava HelloWorld");

        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String info = "";
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
        }*/

        try {
            URL[] urls = new URL[]{new URL("file:/"+"C:/myjava/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("HelloWorld");
            //调用加载类的main方法
            Method m=c.getMethod("main", String[].class);
            m.invoke(null,(Object) new String[]{"aa","bb"});
            //由于可变参数是JDK5.0之后才有。上面代码会编译成：m.invoke(null,"aa","bb")，就发生了参数个数不匹配的问题
            // 因此必须要加上（Object）转型，避免这个问题。
            //public static void mmm(Sting[] a,String[] b)
            //public static void main(Sting[] args)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
