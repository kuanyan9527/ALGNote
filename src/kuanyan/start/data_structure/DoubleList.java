package kuanyan.start.data_structure;

public class DoubleList<V> {
    public DNode<V> head = null;
    public int size = 0;

    public int push(DNode<V> node) {
        if (head == null) {
            head = node;
        } else {
            DNode<V> cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            node.last = cur;
        }
        size++;
        return size;
    }

    // 反转双链表
    public void reverse() {
        DNode<V> pre = null;
        DNode<V> next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        head = pre; // 很重要
    }

    public static void main(String[] args) {
        int total = 1000000;
        for (int i = 0; i < total; i++) {
            DGroup<Integer> group = randomList(100, 10000000);
            DoubleList<Integer> list = group.list;
            int[] arr = group.array;
            list.reverse();
            DNode<Integer> cur = list.head;
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

    public static DGroup<Integer> randomList(int maxSize, int maxValue) {
        int size = (int) (Math.random() * maxSize);
        DoubleList<Integer> list = new DoubleList<>();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int value = (int) (Math.random() * maxValue);
            list.push(new DNode<>(value));
            array[i] = value;
        }
        return new DGroup<>(list, array);
    }

}

class DNode<V> {
    public V value;
    public DNode<V> last = null;
    public DNode<V> next = null;

    public DNode(V value) {
        this.value = value;
    }
}

class DGroup<V> {
    DoubleList<V> list;
    int[] array;

    public DGroup(DoubleList<V> list, int[] array) {
        this.list = list;
        this.array = array;
    }
}
