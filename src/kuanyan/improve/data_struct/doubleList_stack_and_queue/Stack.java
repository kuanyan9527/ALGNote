package kuanyan.improve.data_struct.doubleList_stack_and_queue;

import kuanyan.improve.data_struct.DoubleLinkedList;
import kuanyan.improve.data_struct.DoubleListNode;

// 双链表实现栈
public class Stack<T> {
    public int size = 0;
    public DoubleListNode<T> top = null;
    private DoubleLinkedList<T> list = new DoubleLinkedList<>();

    public void push(T value) {
        list.addLast(value);
        if (size == 0) {
            top = list.first;
        } else {
            top = top.next;
        }
        size++;
    }

    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("栈内没有元素");
        }
        T value = top.value;
        top = top.last;
        list.removeLast();
        size--;
        return value;
    }

    public T peek() throws Exception {
        if (size == 0) {
            throw new Exception("栈内没有元素");
        }
        return top.value;
    }

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(1231);
    }
}
