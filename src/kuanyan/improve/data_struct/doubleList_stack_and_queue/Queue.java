package kuanyan.improve.data_struct.doubleList_stack_and_queue;

import kuanyan.improve.data_struct.DoubleLinkedList;

public class Queue<T> {
    private DoubleLinkedList<T> list = list = new DoubleLinkedList<>();
    public int size = 0;

    public void push(T value) {
        list.addFirst(value);
        size++;
    }

    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("队列中没有元素");

        }
        T valule = list.last.value;
        list.removeLast();
        size--;
        return valule;
    }

    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println(123);
    }
}
