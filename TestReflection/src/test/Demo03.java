package test;

import test.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 */
public class Demo03 {
    public static void main(String[] args) {
        String path = "test.bean.User";
        try {
            Class<?> clazz = Class.forName(path);

            //通过动态调用构造方法，构造对象
            User u= (User) clazz.newInstance();//调用了User的无参构造方法
            System.out.println(u);

            Constructor<User> c = (Constructor<User>) clazz.getDeclaredConstructor(int.class, int.class, String.class);
            User user = c.newInstance(1, 1, "名字");
            System.out.println(user.getUname());

            //通过反射API调用普通方法
            User u3 = (User) clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3, "weiwei");
            System.out.println(u3.getUname());


            //通过反射API操作属性
            User u4 = (User) clazz.newInstance();
            Field field = clazz.getDeclaredField("uname");
            field.setAccessible(true);
            field.set(u4,"weiwei4");
            System.out.println(u4.getUname());
            System.out.println(field.get(u4));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
