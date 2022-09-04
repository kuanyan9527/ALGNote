package kuanyan.improve.data_struct;

// 实现一个单链表
public class LinkedList<T> {
    public ListNode<T> head = null;
    public int size = 0;

    public void add(T value) {
        ListNode<T> node = new ListNode<>(value);
        if (head == null) {
            head = node;
        } else {
            ListNode<T> cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        size++;
    }

    public ListNode<T> remove(T value) {
        if (head == null) {
            return null;
        }
        while (head.value == value) {
            head = head.next;
        }
        ListNode<T> cur = head;
        ListNode<T> pre = null;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
            size--;
        }
        return head;
    }

    public ListNode<T> reverse() {
        if (head == null) {
            return null;
        }
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        ListNode<T> next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
        return head;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.reverse();
        printListValue(list);
    }

    public static void printListValue(LinkedList<Integer> list) {
        ListNode<Integer> cur = list.head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
}
