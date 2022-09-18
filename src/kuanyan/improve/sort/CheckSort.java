package kuanyan.improve.sort;

import kuanyan.common.Common;
import kuanyan.improve.sort.merge_sort.MergeSort;
import kuanyan.improve.sort.merge_sort.MergeSort2;

// 排序算法的对数器
public class CheckSort {
    public static int[] randomArray(int maxValue, int maxLength) {
        int length = randomRangeNumber(maxLength);
        int[] res = new int[length];
        for (int j = 0; j < length; j++) {
            res[j] = randomRangeNumber(maxValue);
        }
        return res;
    }

    // 返回以恶1到max - 1的整数
    public static int randomRangeNumber(int max) {
        return (int) (Math.random() * max);
    }

    public static boolean compareArrayEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        int len1 = arr1.length;
        int len2 =arr2.length;
        if (len1 != len2) {
            return false;
        }
        for(int i = 0; i < len1; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int maxValue = 100;
        int maxLength = 20000;
        int total = 100;
        System.out.println("测试开始");
        for (int i = 0; i < total; i++) {
            int[] array = randomArray(maxValue, maxLength);
            int[] a1 = Common.copyIntArray(array);
            BubbleSort.bubbleSort1(a1);
            int[] a2 = Common.copyIntArray(array);
            BubbleSort.bubbleSort2(a2);
            int[] a3 = Common.copyIntArray(array);
            SelectSort.selectSort(a3);
            int[] a4 = Common.copyIntArray(array);
            InsertSort.insertSort(a4);
            int[] a5 = Common.copyIntArray(array);
            MergeSort.mergeSort(a5);
            int[] a6 = Common.copyIntArray(array);
            MergeSort2.mergeSort(a6);

            if (!compareArrayEqual(a1, a2)) {
                System.out.println("出错了");
                Common.printIntArray(a1);
                Common.printIntArray(a2);
                break;
            }
            if (!compareArrayEqual(a1, a3)) {
                System.out.println("出错了");
                Common.printIntArray(a1);
                Common.printIntArray(a3);
                break;
            }
            if (!compareArrayEqual(a1, a4)) {
                System.out.println("出错了");
                Common.printIntArray(a1);
                Common.printIntArray(a4);
                break;
            }
            if (!compareArrayEqual(a1, a5)) {
                System.out.println("MergeSort出错了");
                Common.printIntArray(a1);
                Common.printIntArray(a5);
                break;
            }
            if (!compareArrayEqual(a1, a6)) {
                System.out.println("MergeSort2出错了");
                Common.printIntArray(a1);
                Common.printIntArray(a6);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
