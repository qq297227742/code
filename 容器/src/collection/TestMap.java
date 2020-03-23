package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HasMap的使用
 * 16 数组默认初始化大小 必须为2的整数幂
 * 0.75 扩容
 * 8 转化为树
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        String str = map.get(1);
        System.out.println(str);

        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("three"));

        Map<Integer,String> map1=new HashMap<>();
        map1.put(4, "四");
        map1.put(5, "五");

        map.putAll(map1);
        System.out.println(map);
    }
}
