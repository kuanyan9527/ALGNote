package kuanyan.improve.data_struct;

import kuanyan.improve.data_struct.doubleList_stack_and_queue.Stack;

// 只用栈实现队列
public class QueueWithStack {
    public Stack<Integer> src = new Stack<>();
    public Stack<Integer> help = new Stack<>();

    public void push(int value) {
        src.push(value);
    }

    public int pop() throws Exception {
        if (help.size == 0) {
            int size = src.size;
            for (int i = 0; i < size; i++) {
                help.push(src.pop());
            }
        }
        return help.pop();
    }

    public static void main(String[] args) throws Exception {
        QueueWithStack queue = new QueueWithStack();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(5);
        queue.push(6);
        queue.push(7);
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(8);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
