package kuanyan.improve.sort;

import kuanyan.common.Common;

public class BubbleSort {
    // 冒泡排序
    // 外层循环控制从头至尾的遍历轮数
    // 内层循环比较相邻两个元素，将大的往后放
    // 时间复杂度为O(n²)
    // 空间复杂度为O(1)
    public static void bubbleSort1(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = 0, len = array.length; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (array[j - 1] > array[j]) {
                    Common.swapInArray(array, j - 1, j);
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    Common.swapInArray(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = { 4, 7, 1, 5, 3, 9, 8, 0 ,2, 6 };
        bubbleSort1(array1);
        Common.printIntArray(array1);
        int[] array2 = { 4, 7, 1, 5, 3, 9, 8, 0 ,2, 6 };
        bubbleSort2(array2);
        Common.printIntArray(array2);
    }
}
