package mycollection;
/**
 * 增加set和get方法
 * 增加数组边界检查
 */

import java.util.Arrays;

public class SxtArrayList05<E> {
    private Object[] elementData;
    private int size;

    public static final int DEFAULT_CAPACITY = 10;

    public SxtArrayList05() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public SxtArrayList05(int capacity){
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

    public void remove(E element) {
        //element,将他们所有元素挨个比较，获得第一个比较为true的返回。
        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {
                remove(i);
            }
        }
    }

    public void remove(int index) {
        checkRange(index);
        //a,b,c,d,e,f,g
        //a,b,c,e,f,g
        int numMoved = elementData.length - index - 1;
        System.arraycopy(elementData,index+1,elementData,index,numMoved);
        elementData[size--] = null;
    }
    @Override
    public String toString() {
        return "SxtArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        SxtArrayList05 sl=new SxtArrayList05(20);

        for (int i = 0; i <40 ; i++) {
            sl.add("aaa"+i);
        }
        System.out.println(sl);
//        sl.set("dddd",40);
        System.out.println(sl.get(10));
        sl.remove(0);
        System.out.println(sl);
    }
}
