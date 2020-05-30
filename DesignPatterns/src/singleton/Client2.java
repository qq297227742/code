package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解单例模式
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        SingletonDemo06 s1 = SingletonDemo06.getInstance();
        SingletonDemo06 s2 = SingletonDemo06.getInstance();

        System.out.println(s1);
        System.out.println(s2);


        //通过反射的方式直接调用私有构造器
        /*Class<?> clazz = Class.forName("singleton.SingletonDemo06");
        Constructor<SingletonDemo06> c = (Constructor<SingletonDemo06>) clazz.getDeclaredConstructor(null);

        c.setAccessible(true);
        SingletonDemo06 s3 = c.newInstance();
        SingletonDemo06 s4 = c.newInstance();

        System.out.println(s3);
        System.out.println(s4);*/

        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingletonDemo06 s3 = (SingletonDemo06) ois.readObject();
        System.out.println(s3);

    }
}
