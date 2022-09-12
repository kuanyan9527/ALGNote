package kuanyan.improve.data_struct.array_stack_and_queue;

public class Stack {
    public static final int CAPACITY = 5;
    public int[] array = new int[CAPACITY];
    public int last = -1;
    public int size = 0;

    public void push(int value) throws Exception {
        if (size == CAPACITY) {
            throw new Exception("栈已满");
        }
        last = (last + 1) == CAPACITY ? 0 : last + 1;
        array[last] = value;
        size++;
    }

    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("栈中没有元素");
        }
        int value = array[last];
        last = last - 1 < 0 ? CAPACITY - 1 : last - 1;
        size--;
        return value;
    }

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
