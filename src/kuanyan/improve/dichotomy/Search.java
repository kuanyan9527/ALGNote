package kuanyan.improve.dichotomy;

import kuanyan.common.Common;
import kuanyan.improve.sort.BubbleSort;

public class Search {
    // 二分法在有序数组中查找某个元素
    // 时间复杂度为O(logN)
    // 空间复杂度O(1)
    public static int search(int[] array, int find) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止mid结果溢出
            if (array[mid] == find) {
                return mid;
            } else if (array[mid] < find) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    public static int s2(int[] array, int find) {
        if (array == null || array.length == 0) {
            return -1;
        }

        for (int i = 0, len = array.length; i < len; i++) {
            if (array[i] == find) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int maxValue = 100;
        int maxLength = 100;
        int total = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < total; i++) {
            int[] array = Common.randomArray(maxValue , maxLength);
            BubbleSort.bubbleSort1(array);
            int find = Common.randomRangeNumber(maxValue);
            int index = search(array, find);
            if ((index != -1 && array[index] != find) && s2(array, find) != index) {
                System.out.println("出错了");
                Common.printIntArray(array);
                System.out.println("find = " + find);
                System.out.println("index = " + index);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
