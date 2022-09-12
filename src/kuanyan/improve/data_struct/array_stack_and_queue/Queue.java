package kuanyan.improve.data_struct.array_stack_and_queue;

// 数组实现固定长度的队列
public class Queue {
    public static final int CAPACITY = 5;

    public int[] array = new int[CAPACITY];
    public int size = 0;
    public int first = 0;
    public int last = 0;

    public void push(int value) throws Exception {
        if (size == CAPACITY) {
            throw new Exception("队列已满");
        }
        array[last] = value;
        last = (last + 1) == CAPACITY ? 0 : (last + 1);
        size++;
    }

    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("队列中没有元素");
        }
        int value = array[first];
        first = (first + 1 == CAPACITY) ? 0 : (first + 1);
        size--;
        return value;
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop());
        queue.push(6);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
