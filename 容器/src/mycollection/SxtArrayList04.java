package mycollection;
/**
 * 增加set和get方法
 * 增加数组边界检查
 */

import java.util.Arrays;

public class SxtArrayList04<E> {
    private Object[] elementData;
    private int size;

    public static final int DEFAULT_CAPACITY = 10;

    public SxtArrayList04() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public SxtArrayList04(int capacity){
        if (capacity < 0) {
            throw new RuntimeException("容量不能为负数");
        } else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
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

    public E get(int index) {
            checkRange(index);
            return (E) elementData[index];

    }

    public void set(E element, int index) {
        checkRange(index);
            elementData[index] = element;

    }
public void checkRange(int index){
    if (index < 0 || index > size - 1) {
        throw new RuntimeException("索引不在范围内:"+index);
    }
}

    @Override
    public String toString() {
        return "SxtArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        SxtArrayList04 sl=new SxtArrayList04(20);

        for (int i = 0; i <40 ; i++) {
            sl.add("aaa"+i);
        }
        System.out.println(sl);
        sl.set("dddd",40);
        System.out.println(sl.get(10));

    }
}
