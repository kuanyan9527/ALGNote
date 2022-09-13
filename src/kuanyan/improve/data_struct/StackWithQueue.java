package kuanyan.improve.data_struct;

import kuanyan.improve.data_struct.array_stack_and_queue.Queue;

// 只是用队列实现一个栈
// 使用连个队列实现
public class StackWithQueue {
    private Queue src = new Queue();
    private Queue help = new Queue();
    private int size = 0;

    public void push(int value) throws Exception {
        src.push(value);
        size++;
    }

    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("队列为空");
        }
        while (src.size > 1) {
            help.push(src.pop());
        }
        int res = src.pop();
        size--;
        Queue temp = src;
        src = help;
        help = temp;
        return res;
    }

    public static void main(String[] args) throws Exception {
        StackWithQueue stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
