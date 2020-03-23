package mycollection;

/**
 * 实现put方法
 * 实现toString
 */
public class SxtHashMap02 {
    Node2[] table;
    int size;

    public SxtHashMap02() {
        table = new Node2[16];//长度一般定义成2的整数幂
    }

    public void put(Object key, Object value) {
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node2 iterLast=null;

        Node2 temp = table[newNode.hash];
        if (temp == null) {
            table[newNode.hash] = newNode;
        }else{
            while (temp != null) {
                //判断key 如果重复，则覆盖
                if (temp.key.equals(key)) {
                    System.out.println("key重复了！！");
                    temp.value = value;//只覆盖value
                    break;
                }else {
                    //key不重复,则遍历下一个
                    iterLast=temp;
                    temp = temp.next;
                }

            }

            if (temp == null) {
                iterLast.next = newNode;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < table.length; i++) {
            Node2 temp = table[i];
            while (temp != null) {
                stringBuilder.append(temp.key + "=" + temp.value + ",");
                temp = temp.next;
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SxtHashMap02 m=new SxtHashMap02();
        for (int i = 0; i < 100; i++) {
            m.put(i,i+i);
        }
        System.out.println(m);
    }

    public int myHash(int v, int length) {
//        System.out.println("hash in myHash  "+(v&(length-1)));//直接位运算，效率高
//        System.out.println("hash in myHash  "+(v%(length)));//取模运算，效率低
        return v & (length - 1);
    }
}
