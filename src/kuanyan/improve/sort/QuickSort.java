package kuanyan.improve.sort;

import kuanyan.common.Common;
import kuanyan.improve.data_struct.doubleList_stack_and_queue.Stack;

public class QuickSort {
    // 快速排序递归版本，时间复杂度O(N * logN)
    public static void quickSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length - 1);
    }

    public static void process(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        swap(array, (int)(Math.random() * (right - left + 1)) + left, right); // 重要
        int[] next = sort(array, left, right);
        process(array, left, next[0]);
        process(array, next[1], right);
    }

    public static int[] sort(int[] array, int left, int right) {
        int spitVal = array[right];
        int less = left - 1;
        int big = right;
        int current = left;
        while (current < big) {
            if (array[current] < spitVal) {
                swap(array, current, ++less);
                current++;
            } else if (array[current] > spitVal) {
                swap(array, current, --big);
            } else {
                current++;
            }
        }
        swap(array, big++, right); // big++为了还原大于等于区
        big = Math.min(big, right);
        return new int[] { less, big };
    }

    // 快速排序非递归版本
    public static void quickSort(int[] array) throws Exception {
        if (array == null || array.length < 2) {
            return;
        }
        int l = 0, r = array.length - 1;
        swap(array, (int)(Math.random() * (r - l + 1)) + l, r); // 重要
        Stack<int[]> stack = new Stack<>();
        int[] m = sort(array, l, r);
        stack.push(new int[]{ l, m[0] });
        stack.push(new int[]{ m[1], r });
        while (stack.size != 0) {
            m = stack.pop();
            if (m[0] >= m[1]) {
                continue;
            }
            int[] k = sort(array, m[0], m[1]);
            stack.push(new int[]{ m[0], k[0] });
            stack.push(new int[]{ k[1], m[1] });
        }
    }

    public static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static void main(String[] args) throws Exception {
        int[] array = { 2, 1, 5, 4, 2, 3, 7, 3, 0, 5, 7 };
        quickSort(array);
        Common.printIntArray(array);
    }
}
