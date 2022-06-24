package kuanyan.start.dichotomy;

public class LocalMin {
    public static void main(String[] args) {
        // 在一个相邻不相等的数组中找到一个局部最小值的位置
        int total = 500000;
        for (int i = 0; i< total; i++) {
            int[] arr = randomArray(20, 50);
            int ans = findLocalMin(arr);
            if (!test(arr, ans)) {
                System.out.println("出错了，ans = " + ans);
                FindNum.printArr(arr);
            }
        }
        System.out.println("成功");
    }

    public static int findLocalMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        if (len == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[len - 1] < arr[len - 2]) {
            return len - 1;
        }
        int l = 1;
        int r = len - 2;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans = mid;
            }
            if (arr[mid - 1] < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len == 0) {
            return arr;
        }
        arr[0] = (int) (Math.random() * maxValue);
        for (int i = 1; i < len; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue);
            } while (arr[i - 1] == arr[i]);
        }
        return arr;
    }

    public static boolean test(int[] arr, int ans) {
        if (arr == null || arr.length == 0) {
            return ans == -1;
        }
        int len = arr.length;
        if (len == 1) {
            return ans == 0;
        }
        if (arr[0] < arr[1]) {
            return ans == 0;
        }
        if (arr[len - 1] < arr[len - 2]) {
            return ans == len - 1;
        }
        return arr[ans] < arr[ans - 1] && arr[ans] < arr[ans + 1];
    }
}
