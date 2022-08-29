package kuanyan.improve.sort;

import kuanyan.common.Common;

public class SelectSort {
    // 选择排序
    // 每次指定一个最小值的下标，然后遍历比较剩下的元素，如果比指定的下标值小则将最小值下标指定为当前元素的下标
    // 一轮遍历完将最小值于数组第一个元素交换，以此类推遍历完整个数组
    // 时间复杂度为O(n²)
    // 空间复杂度O(1)
    public static void selectSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = 0, len = array.length; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            Common.swapInArray(array, minIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 7, 1, 5, 3, 9, 8, 0 ,2, 6 };
        selectSort(array);
        Common.printIntArray(array);
    }
}
