package kuanyan.start.data_structure.linked_list;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

// 单链表实现队列
public class MyQueue<V> {
    private int size = 0;
    public Node<V> head = null;
    public Node<V> tail = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int offset(V value) {
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            Node<V> node = new Node<>(value);
            tail.next = node;
            tail = node;
        }
        size++;
        return size;
    }

    public V poll() {
        V res = null;
        if (head != null) {
            res = head.value;
            head = head.next;
            size--;
        }
        return res;
    }

    public V peek() {
        return head == null ? null : head.value;
    }

    public static void main(String[] args) {
        int total = 1000000;
        Queue<Integer> queue = new LinkedList<>();
        MyQueue<Integer> myQueue = new MyQueue<>();
        for (int i = 0; i < total; i++) {
            double random = Math.random();
            if (random < 0.33) {
                if (queue.size() != myQueue.size()) {
                    System.out.println("size方法出错了");
                    break;
                }
                if(queue.isEmpty() != myQueue.isEmpty()) {
                    System.out.println("isEmpty方法出错了");
                    break;
                }
                int num = (int) (Math.random() * 10000);
                queue.offer(num);
                myQueue.offset(num);
            } else if (random < 0.66) {
                queue.poll();
                myQueue.poll();
            } else {
                if (!Objects.equals(queue.peek(), myQueue.peek())) {
                    System.out.println("peek方法出错了");
                    break;
                }
            }
        }
        System.out.println("成功");
    }
}
