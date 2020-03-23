package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试泛型
 */
public class TestGeneric {
    public static void main(String[] args) {
        MyCollection<String> myCollection=new MyCollection<>();
        myCollection.set("搞起",0);
//        myCollection.set(888,1);
//        Integer a =  myCollection.get(1);
        String b =  myCollection.get(0);


        List list=new ArrayList();
        Map map=new HashMap();
    }
}

class MyCollection <T>{
    Object[] objects = new Object[5];

    public void set(T object, int index) {
        objects[index]=object;
    }

    public T get(int index) {
        return (T) objects[index];
    }
}