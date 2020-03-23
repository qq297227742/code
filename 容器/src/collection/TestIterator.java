package collection;

import java.util.*;

/**
 * 测试迭代器遍历List，Set，Map
 * @author weiwei
 */
public class TestIterator {
    public static void main(String[] args) {

        //testIteratorList();
//        testIteratorSet();
        testIteratorMap();
    }
    public static void testIteratorList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }
    public static void testIteratorSet() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String temp = iterator.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorMap() {
        Map<Integer,String> map=new HashMap<>();
        map.put(100, "aa");
        map.put(200, "bb");
        map.put(300, "cc");

        //第一种遍历方式
        Set<Map.Entry<Integer, String>> ss= map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = ss.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        //第二种遍历方式
        Set<Integer> setKey = map.keySet();
        for (Iterator<Integer> integerIterator = setKey.iterator(); integerIterator.hasNext(); ) {
            Integer key=integerIterator.next();
            System.out.println(key+"=" + map.get(key));
        }
    }
}
