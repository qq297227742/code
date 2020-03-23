package mycollection;

/**
 * 实现put方法
 */
public class SxtHashMap01 {
    Node2[] table;
    int size;

    public SxtHashMap01() {
        table = new Node2[16];//长度一般定义成2的整数幂
    }

    public void put(Object key, Object value) {
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;


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
                    temp = temp.next;
                }

            }

            if (temp == null) {
                temp = newNode;
            }
        }
    }

    public static void main(String[] args) {
        SxtHashMap01 m=new SxtHashMap01();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        System.out.println(m);
    }

    public int myHash(int v, int length) {
        System.out.println("hash in myHash  "+(v&(length-1)));//直接位运算，效率高
        System.out.println("hash in myHash  "+(v%(length)));//取模运算，效率低
        return v & (length - 1);
    }
}
