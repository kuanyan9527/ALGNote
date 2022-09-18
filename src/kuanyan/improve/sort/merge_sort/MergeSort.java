package kuanyan.improve.sort.merge_sort;

import kuanyan.common.Common;

// 归并排序，递归写法
public class MergeSort {
    public static void mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        process(array, 0, array.length - 1);
    }


    public static void process(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        process(array, left, mid);
        process(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int helpIndex = 0;
        while (p1 <= mid && p2 <= right) {
            if (array[p1] <= array[p2]) {
                help[helpIndex] = array[p1];
                p1++;
            } else {
                help[helpIndex] = array[p2];
                p2++;
            }
            helpIndex++;
        }

        while (p1 <= mid) {
            help[helpIndex] = array[p1];
            p1++;
            helpIndex++;
        }

        while (p2 <= right) {
            help[helpIndex] = array[p2];
            p2++;
            helpIndex++;
        }

        int index = 0;
        for(int i = left; i <= right; i++) {
            array[i] = help[index++];
        }
    }

    public static void main(String[] args) {
        int[] array = { 2, 6, 4, 9, 1, 4, 5, 3, 7, 8 };
        mergeSort(array);
        Common.printIntArray(array);
    }
}
