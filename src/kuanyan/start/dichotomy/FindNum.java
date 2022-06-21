package kuanyan.start.dichotomy;

public class FindNum {
    public static void main(String[] args) {
        // 在有序数组中使用二分法查找一个数num
        int total = 500000;
        for (int i = 0; i < total; i++) {
            int[] arr = randomArray(20, 100);
            int res = findNum(arr, 20);
            if (!test(arr, 20, res)) {
                System.out.println("出错了");
                printArr(arr);
                System.out.println(res);
            }
        }
        System.out.println("成功");
    }

    public static int findNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == num) {
                ans = mid;
                break;
            }
            if (arr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static boolean test(int[] arr, int target, int ans) {
        if (arr == null || arr.length == 0) {
            return ans == -1;
        }
        for (int i = 0, len = arr.length; i < len; i++) {
            if (arr[i] == target && i == ans) {
                return true;
            }
        }
        return ans == -1;
    }

    public static int[] randomArray(int maxLength, int maxValue) {
        int len = (int) (Math.random() * maxLength) + 1;
        int[] arr = new int[len];
        arr[0] = 1;
        for (int i = 1; i < len; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue + 1);
            } while (arr[i] < arr[i - 1]);
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
