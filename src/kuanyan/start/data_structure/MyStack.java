package kuanyan.start.data_structure;

import java.util.ArrayDeque;

// 使用单链表实现栈
public class MyStack<V> {
    public int size = 0;
    public Node<V> top = null;

    public int push(V value) {
        if (top == null) {
            top = new Node<>(value);
        } else {
            Node<V> node = new Node<>(value);
            node.next = top;
            top = node;
        }
        size++;
        return size;
    }

    public V pop() {
        V res = null;
        if (top != null) {
            res = top.value;
            top = top.next;
            size--;
        }
        return res;
    }

    public static void main(String[] args) {
        int total = 1000000;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i < total; i++) {
            double random = Math.random();
            if (random < 0.8) {
                int value = (int) (Math.random() * 1000);
                deque.push(value);
                myStack.push(value);
                if (deque.size() != myStack.size) {
                    System.out.println("size出错了");
                    break;
                }
            } else {
                if (deque.isEmpty()) {
                    break;
                }
                int r1 =deque.pop();
                int r2 = myStack.pop();
                if (r1 != r2) {
                    System.out.println("pop()出错了");
                    System.out.println(r1 + " " + r2);
                    break;
                }
            }
        }
        System.out.println("成功");
    }
}
