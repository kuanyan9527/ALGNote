package kuanyan.start.dichotomy;

import kuanyan.start.sort.sort;

public class FindMostRightNum {
    public static void main(String[] args) {
        // 有序数组中找到<=num最右的位置
        int total = 1000000;
        for (int i = 0; i < total; i++) {
            int[] arr = randomArray(20, 100);
            int ans = finMostRightNum(arr, 7);
            if (!test(arr, 7, ans)) {
                System.out.println("出错了，ans = " + ans);
                FindNum.printArr(arr);
                break;
            }
        }
        System.out.println("成功");
    }

    public static int finMostRightNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= num) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        sort.selectSort(arr);
        return arr;
    }

    public static boolean test(int[] arr, int target, int ans) {
        int index = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= target) {
                index = i;
                break;
            }
        }
        return index == ans;
    }
}
