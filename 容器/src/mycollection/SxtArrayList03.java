package mycollection;
/**
 * 增加数组扩容
 */

import java.util.Arrays;

public class SxtArrayList03<E> {
    private Object[] elementData;
    private int size;

    public static final int DEFAULT_CAPACITY = 10;

    public SxtArrayList03() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public SxtArrayList03(int capacity){
        elementData=new Object[capacity];
    }

    public void add(E element) {
        //什么时候扩容
        if (size == elementData.length) {
            //扩容操作
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }

    @Override
    public String toString() {
        return "SxtArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        SxtArrayList03 sl=new SxtArrayList03(20);
        sl.add("aa");
        System.out.println(sl);
    }
}
