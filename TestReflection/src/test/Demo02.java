package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息（名字、属性、方法。构造器等）
 * @author weiwei
 */
public class Demo02 {
    public static void main(String[] args) {
        String path = "test.bean.User";
        try {
            Class<?> clazz = Class.forName(path);

            //获取类的名字
            System.out.println(clazz.getName());//获得包名+类名
            System.out.println(clazz.getSimpleName());//获得类名

            //获取属性信息
            //Field[] fields = clazz.getFields();//只能获得public的field
            Field[] fields = clazz.getDeclaredFields();//获得所有field
            Field uname = clazz.getDeclaredField("uname");
            System.out.println(fields.length);
            for (Field temp :
                    fields) {
                System.out.println("属性："+temp);
            }
            //获取方法信息
            Method[] methods = clazz.getDeclaredMethods();
            Method method01 = clazz.getDeclaredMethod("getUname", null);
            Method method02 = clazz.getDeclaredMethod("setUname", String.class);//如果方法有参数，则必须传递参数类型对应的Class对象
            for (Method temp :
                    methods) {
                System.out.println("方法："+temp);
            }

            //获取构造器信息
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            System.out.println("获得构造器："+constructor);
            for (Constructor temp :
                    constructors) {
                System.out.println("构造器："+temp);
            }

        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
