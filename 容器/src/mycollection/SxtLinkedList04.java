package mycollection;

public class SxtLinkedList04 {
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

    public void add(int index, Object object) {
        Node temp = getNode(index);
        Node up=temp.previous;
        //Node down=temp.next;
        Node newNode = new Node(object);

        if (up != null) {
            up.next=newNode;
            newNode.previous =up ;
            newNode.next = temp;
            temp.previous=newNode;
        }

        if (index == 0) {
            newNode.next=first;
            first.previous=newNode;
            first=newNode;
        }

        size++;
    }

    public void remove(int index) {
        Node temp = getNode(index);
        if (temp != null) {
            Node up = temp.previous;
            Node down = temp.next;

            if (up != null) {
                up.next = down;
            }
            if (down != null) {
                down.previous = up;
            }

            if (index == 0) {
                first=down;
            }
            if (index == size - 1) {
                last = up;
            }
            temp.previous=null;
            temp.next = null;
        }
        size--;
    }

    public Object get(int index) {
        Node node = getNode(index);
        return node!=null?node.element:null;
    }

    public Node getNode(int index) {
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
        return node;
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
        SxtLinkedList04 list=new SxtLinkedList04();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        list.add(3,"0");
        System.out.println(list);
    }
}
