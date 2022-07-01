package kuanyan.start.data_structure.linked_list;

public class LinkedList<V> {
    public Node<V> head = null;
    public int size = 0;

    public int push(Node<V> node) {
        if (head == null) {
            head = node;
        } else {
            Node<V> cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        size++;
        return size;
    }

    // 反转单链表
    public void reverse() {
        Node<V> pre = null;
        Node<V> next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head = pre;
    }


    public static void main(String[] args) {
        int total = 1000000;
        for (int i = 0; i < total; i++) {
            Group<Integer> group = randomList(100, 10000000);
            LinkedList<Integer> list = group.list;
            int[] arr = group.array;
            list.reverse();
            Node<Integer> cur = list.head;
            for (int j = arr.length - 1; j >= 0; j--) {
                if (cur.value != arr[j]) {
                    System.out.println("出错了");
                    break;
                }
                cur = cur.next;
            }
        }
        System.out.println("成功");
    }

    public static Group<Integer> randomList(int maxSize, int maxValue) {
        int size = (int) (Math.random() * maxSize);
        LinkedList<Integer> list = new LinkedList<>();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int value = (int) (Math.random() * maxValue);
            list.push(new Node<>(value));
            array[i] = value;
        }
        return new Group<>(list, array);
    }
}

class Group<V> {
    LinkedList<V> list;
    int[] array;

    public Group(LinkedList<V> list, int[] array) {
        this.list = list;
        this.array = array;
    }
}

class Node<V> {
    public V value;
    public Node<V> next = null;

    public Node(V value) {
        this.value = value;
    }
}
