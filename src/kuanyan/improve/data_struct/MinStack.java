package kuanyan.improve.data_struct;

import kuanyan.improve.data_struct.doubleList_stack_and_queue.Stack;

// 获取栈内最小值，要求时间复杂度位O(1)
// 使用两个栈完成
public class MinStack {
    private Stack<Integer> src = new Stack<>();
    private Stack<Integer> min = new Stack<>();


    public void push(int value) throws Exception {
        if (src.size == 0) {
            src.push(value);
            min.push(value);
        } else {
            int minVal = min.peek();
            minVal = Math.min(minVal, value);
            src.push(value);
            min.push(minVal);
        }

    }

    public int pop() throws Exception {
        int val = src.pop();
        min.pop();
        return val;
    }

    public int getMin() throws Exception {
        return min.peek();
    }


    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();

        minStack.push(10);
        minStack.push(19);
        minStack.push(4);
        minStack.push(6);
        minStack.push(2);
        minStack.push(20);
        minStack.push(-1);

        minStack.pop();
        minStack.pop();
        minStack.pop();

        System.out.println(minStack.getMin());
    }
}
