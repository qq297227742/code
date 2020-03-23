package mycollection;

public class SxtLinkedList02 {
    private Node first;
    private Node last;
    private int size;

    public void add(Object object) {
        size++;
        Node node = new Node(object);
        if (first == null) {
            first = node;
            last = node;
        }else{
            node.previous=last;
            node.next = null;

            last.next=node;
            last = node;
        }
    }

    public Object get(int index) {
        checkedRange(index);
        Node node = null;
        if (index <= (size >> 1)) {
            node=first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.previous;
            }
        }
        return node.element;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
                Node temp = first;
        while (temp != null) {
            stringBuilder.append(temp.element+",");
            temp = temp.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void checkedRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引不合法：" + index);
        }
    }

    public static void main(String[] args) {
        SxtLinkedList02 list=new SxtLinkedList02();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        //System.out.println(list);
        System.out.println(list.get(6));
    }
}
