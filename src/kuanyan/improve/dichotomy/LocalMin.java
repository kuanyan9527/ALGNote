package kuanyan.improve.dichotomy;

import kuanyan.common.Common;

// 找到一个局部最小问题
// 任意两个相邻两个元素不相等
// 时间复杂读O(logN)
// 空间复杂读O(1)
public class LocalMin {
    public static int process(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int len = array.length;
        if (len == 1) {
            return 0;
        }
        if (array[0] < array[1]) {
            return 0;
        }
        if (array[len - 1] < array[len - 2]) {
            return len - 1;
        }
        int left = 0;
        int right = len - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid - 1] < array[mid]) {
                right = mid;
            } else if (array[mid + 1] < array[mid]) {
                left = mid;
            } else {
                res = mid;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int maxValue = 100;
        int maxLength = 100;
        int total = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < total; i++) {
            int[] array = randomArray(maxValue, maxLength);
            int res = process(array);
            if (!testProcess(array, res)) {
                System.out.println("出错了");
                Common.printIntArray(array);
                System.out.println("res: " + res);
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static boolean testProcess(int[] array, int index) {
        if (array == null || array.length == 0) {
            return -1 == index;
        }
        int len =array.length;
        if (len == 1) {
            return 0 == index;
        }
        if (array[0] < array[1]) {
            return 0 == index;
        }
        if (array[len - 1] < array[len - 2]) {
            return len - 1 == index;
        }
        if (index == -1) {
            // 再去找一遍
            for (int i = 1; i < len - 2; i++) {
                if (array[i] < array[i - 1] && array[i] < array[i + 1]) {
                    return false;
                }
            }
        } else {
            return array[index] < array[index -1] && array[index] < array[index + 1];
        }
        return false;
    }

    public static int[] randomArray(int maxValue, int maxLength) {
        int len = (int) (Math.random() * maxLength);
        int[] array = new int[len];
        int last = -1;
        int value = 0;
        for (int i = 0; i < len; i++) {
            do {
                value = (int) (Math.random() * maxValue);
            } while (last == value);
            last = value;
            array[i] = value;
        }
        return array;
    }

    public static void main2(String[] args) {
        int[] array = { 5, 4, 6, 3, 6, 7, 4, 6};
        int res = process(array);
        System.out.println(res);
    }
}
