package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("gao" + i);
        }
        System.out.println(list);

        //随机排列list中的元素
        Collections.shuffle(list);
        System.out.println(list);

        //逆序排列
        Collections.reverse(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        int temp = Collections.binarySearch(list, "gao1");
        System.out.println(temp);
    }
}
