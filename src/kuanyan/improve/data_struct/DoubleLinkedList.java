package kuanyan.improve.data_struct;

public class DoubleLinkedList<T> {
    public DoubleListNode<T> first = null;
    public DoubleListNode<T> last = null;
    public int size = 0;

    public void addFirst(T value) {
        DoubleListNode<T> node = new DoubleListNode<>(value);
        if (size == 0) {
            last = node;
        } else {
            node.next = first;
            first.last = node;
        }
        first = node;
        size++;
    }

    public void addLast(T value) {
        DoubleListNode<T> node = new DoubleListNode<>(value);
        if (size == 0) {
            first = node;
        } else {
            last.next = node;
            node.last = last;
        }
        last = node;
        size++;
    }

    public DoubleListNode<T> remove(T value) {
        if (size == 0) {
            return null;
        }
        while (first.value == value) {
            first = first.next;
            size--;
        }
        while (last.value == value) {
            last = last.last;
            size--;
        }
        DoubleListNode<T> cur = first;
        DoubleListNode<T> pre = null;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
                if (cur.next != null) {
                    cur.next.last = pre;
                }
                size--;
            }
            pre = cur;
            cur = cur.next;
        }
        return first;
    }

    public DoubleListNode<T> removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.last = null;
        }
        size--;
        return first;
    }

    public DoubleListNode<T> removeLast() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            last = null;
            first = null;
        } else {
            last = last.last;
            last.next = null;
        }
        size--;
        return first;
    }

    public DoubleListNode<T> reverse() {
        if (size == 0) {
            return null;
        }
        DoubleListNode<T> cur = first;
        DoubleListNode<T> pre = null;
        DoubleListNode<T> next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            cur.last = next;
            pre = cur;
            cur = next;
        }
        last = first;
        first = pre;
        return first;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        printList(list);

        list.addLast(4);
        printList(list);

        list.reverse();
        printList(list);

        list.addFirst(5);
        list.addLast(0);
        printList(list);

        list.first = list.remove(2);
        printList(list);

        list.first = list.remove(5);
        list.addFirst(6);
        printList(list);

        list.first = list.remove(0);
        list.addLast(-1);
        printList(list);
    }

    public static void printList(DoubleLinkedList<Integer> list) {
        System.out.println("----------------------------------");
        DoubleListNode<Integer> cur = list.first;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("");
    }
}
