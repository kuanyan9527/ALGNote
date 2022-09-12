package kuanyan.improve.data_struct.doubleList_stack_and_queue;

import kuanyan.improve.data_struct.DoubleLinkedList;
import kuanyan.improve.data_struct.DoubleListNode;

public class DoubleQueue {
    private DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
    public int size = 0;

    public void pushFirst(int value) {
        list.addFirst(value);
        size++;
    }

    public int popFirst() throws Exception {
        if (size == 0) {
            throw new Exception("队列中没有元素");
        }
        DoubleListNode<Integer> fist = list.removeFirst();
        size--;
        return fist.value;
    }

    public void pushLast(int value) {
        list.addLast(value);
        size++;
    }

    public int popLast() throws Exception {
        if (size == 0) {
            throw new Exception("队列中没有元素");
        }
        DoubleListNode<Integer> last = list.removeLast();
        size--;
        return last.value;
    }

    public static void main(String[] args) throws Exception {
        DoubleQueue queue = new DoubleQueue();
        queue.pushFirst(1);
        queue.pushFirst(2);
        queue.pushFirst(3);

        System.out.println(queue.popFirst());

        queue.pushLast(4);
        System.out.println(queue.popFirst());
        queue.pushLast(5);
        System.out.println(queue.popLast());
        System.out.println(queue.popLast());
        System.out.println(queue.popLast());

    }

}
