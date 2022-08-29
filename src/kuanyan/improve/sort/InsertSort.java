package kuanyan.improve.sort;

import kuanyan.common.Common;

public class InsertSort {
    // 插入排序
    // 让第一个元素有序
    // 让前两个元素有序
    // 让前三个元素有序
    // 。。。
    // 让前n个元素有序
    // 时间复杂度O(n²)
    // 空间复杂度O(1)
    public static void insertSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = 0, len = array.length; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    Common.swapInArray(array, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 7, 1, 5, 3, 9, 8, 0 ,2, 6 };
        insertSort(array);
        Common.printIntArray(array);
    }
}
