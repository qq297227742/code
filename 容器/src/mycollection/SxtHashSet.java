package mycollection;

import java.util.HashMap;

/**
 * 手动实现一个HashSet
 */
public class SxtHashSet {
    HashMap map;

    private static final Object PRSENT=new Object();

    public SxtHashSet() {
        map = new HashMap();
    }

    public void add(Object object) {
        map.put(object, PRSENT);
    }

    public int size() {
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (Object key:map.keySet()
             ) {
            stringBuilder.append(key + ",");
        }
        stringBuilder.setCharAt(stringBuilder.length()-1,'}');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SxtHashSet set=new SxtHashSet();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        System.out.println(set);
    }
}
