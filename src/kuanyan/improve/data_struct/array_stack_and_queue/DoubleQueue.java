package kuanyan.improve.data_struct.array_stack_and_queue;

// 数组实现一个固定长度的双端队列
public class DoubleQueue {
    private static final int CAPACITY = 5;
    private int[] array = new int[CAPACITY];
    public int size = 0;
    public int fist = 0;
    public int last = 0;

    public void pushFirst(int value) throws Exception {
        if (size == CAPACITY) {
            throw new Exception("队列已满");
        }
        array[fist] = value;
        if (fist == last && last == 0) {
            last++;
        }
        fist = fist - 1 < 0 ? CAPACITY - 1 : fist - 1;
        size++;
    }

    public int popFirst() throws Exception {
        if (size == 0) {
            throw new Exception("队列为空");
        }
        int value = array[fist];
        fist = fist + 1 == CAPACITY ? 0 : fist + 1;
        size--;
        return value;
    }

    public void pushLast(int value) throws Exception {
        if (size == CAPACITY) {
            throw new Exception("队列已满");
        }
        array[last] = value;
        if (last == fist && last == 0) {
            fist = CAPACITY - 1;
        }
        last = last + 1 == CAPACITY? 0 : last + 1;
        size++;
    }

    public int popLast() throws Exception {
        if (size == 0) {
            throw new Exception("队列为空");
        }
        int value = array[last];
        last = last - 1 > 0 ? last - 1 : CAPACITY - 1;
        size--;
        return value;
    }


    public static void main(String[] args) throws Exception {
        kuanyan.improve.data_struct.doubleList_stack_and_queue.DoubleQueue queue = new kuanyan.improve.data_struct.doubleList_stack_and_queue.DoubleQueue();
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

        System.out.println(12321);
    }
}
