package kuanyan.improve.dichotomy;

import kuanyan.common.Common;
import kuanyan.improve.sort.BubbleSort;

// 有序数组中找到>=某个树最左侧的位置
// 时间复杂度O(logN)
// 空间复杂读O(1)
public class FindNumLeft {
    public static int process(int[] array, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < num) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public static int findByFor(int[] array, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int res = -1;
        for (int i = 0, len = array.length; i < len; i++) {
            if (array[i] >= num) {
                res = i;
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int maxValue = 100;
        int maxLength = 100;
        int total = 200000;
        System.out.println("测试开始");
        for (int i = 0; i < total; i++) {
            int[] array = Common.randomArray(maxValue, maxLength);
            BubbleSort.bubbleSort1(array);
            int num = Common.randomRangeNumber(maxValue);
            int res = process(array, num);
            int resByFor = findByFor(array, num);
            if (res != resByFor) {
                System.out.println("出错了");
                Common.printIntArray(array);
                System.out.println("num " + num);
                System.out.println("res: " + res);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
