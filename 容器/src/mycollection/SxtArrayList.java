package mycollection;

import java.util.Arrays;

public class SxtArrayList {
    private Object[] elementData;
    private int size;

    public static final int DEFAULT_CAPACITY = 10;

    public SxtArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public SxtArrayList(int capacity){
        elementData=new Object[capacity];
    }

    public void add(Object object) {
        elementData[size++] = object;
    }

    @Override
    public String toString() {
        return "SxtArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        SxtArrayList sl=new SxtArrayList(20);
        sl.add("aa");
        System.out.println(sl);
    }
}
