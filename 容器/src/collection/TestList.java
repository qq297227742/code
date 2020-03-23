package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试collection接口中的方法
 */
public class TestList {
    public static void main(String[] args) {

        test03();
    }
    public static void test01() {
        Collection<String> collection = new ArrayList();

        System.out.println(collection.size());
        System.out.println(collection.isEmpty());

        collection.add("老大");
        collection.add("老二");
        System.out.println(collection);
        System.out.println(collection.size());

        System.out.println(collection.contains("老二"));

        Object[] objects = collection.toArray();
        System.out.println(objects);

        collection.remove("老二");
        System.out.println(collection);
        System.out.println(collection.size());

        collection.clear();
        System.out.println(collection.size());
    }
    public static void test02() {
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list01:"+list01);

//        list01.addAll(list02);
//        list01.removeAll(list02);//去除相同的元素

        list01.retainAll(list02);//保留交集部分
        System.out.println("list01:"+list01);
    }
    public static void test03(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);

        list.add(2, "搞起");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.set(2, "高老二");
        System.out.println(list);

        System.out.println(list.get(2));

        list.add("C");
        list.add("B");
        list.add("A");
        System.out.println(list);

        System.out.println(list.indexOf("B"));
        System.out.println(list.lastIndexOf("B"));
    }
}
