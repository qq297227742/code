package test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("test.annotation.Student");
            //获取类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            //获得类的指定的注解
            Table table = (Table) clazz.getAnnotation(Table.class);
            System.out.println(table.value());

            //获得类的属性的注解
            Field studentName = clazz.getDeclaredField("studentName");
            test.annotation.Field field = studentName.getAnnotation(test.annotation.Field.class);
            System.out.println(field.columnName() + "--" + field.type() + "--" + field.length());

            //根据获得的表名、字段的信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库中生成相关的表
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
