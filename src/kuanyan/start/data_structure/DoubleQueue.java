package kuanyan.start.data_structure;

import java.util.Deque;
import java.util.LinkedList;

public class DoubleQueue<V> {
    public DNode<V> head = null;
    public DNode<V> tail = null;
    public int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void pushHead(V value) {
        if (this.head == null) {
            this.head = this.tail = new DNode<>(value);
        } else {
            DNode<V> node = new DNode<>(value);
            node.next = this.head;
            this.head.last = node;
            this.head = node;
        }
        this.size++;
    }

    public void pushTail(V value) {
        if (this.head == null) {
            this.head = this.tail = new DNode<>(value);
        } else {
            DNode<V> node = new DNode<>(value);
            node.last = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public V pollHead() {
        V value = null;
        if (this.head != null) {
            value = this.head.value;
            if (this.head.next == null) {
                this.head = this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.last = null;
            }
           this.size--;
        }
        return value;
    }

    public V pollTail() {
        V value = null;
        if (this.tail != null) {
            value = this.tail.value;
            if (this.tail.last == null) {
                this.head = this.tail = null;
            } else {
                this.tail = this.tail.last;
                this.tail.next = null;
            }
            this.size--;
        }
        return value;
    }

    public static void main(String[] args) {
        int total = 1000000;
        Deque<Integer> list = new LinkedList<>();
        DoubleQueue<Integer> queue = new DoubleQueue<>();
        for (int i = 0; i < total; i++) {
            double random = Math.random();
            if (random < 0.25) {
                if (list.size() != queue.size()) {
                    System.out.println("size()出错了");
                    break;
                }
                if (list.isEmpty() != queue.isEmpty()) {
                    System.out.println("isEmpty()出错了");
                    break;
                }
                int value = (int) (Math.random() * 1000);
                list.addFirst(value);
                queue.pushHead(value);
            } else if (random < 0.5) {
                int value = (int) (Math.random() * 1000);
                list.addLast(value);
                queue.pushTail(value);
            } else if (random < 0.75) {
                int v1 = !list.isEmpty() ? list.pollFirst() : -1;
                int v2 = !queue.isEmpty() ? queue.pollHead() : -1;
                if (v1 != v2) {
                    System.out.println("pollHead出错了");
                    break;
                }
            } else {
                int v1 = !list.isEmpty() ? list.pollLast() : -1;
                int v2 = !queue.isEmpty() ? queue.pollTail() : -1;
                if (v1 != v2) {
                    System.out.println("pollTail出错了");
                    break;
                }
            }
        }
        System.out.println("成功");
    }
}
