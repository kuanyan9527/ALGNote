package kuanyan.improve.sort.merge_sort;

public class CountOfRangeSum {
    // 使用遍历的方式解决, 时间复杂度为O(n的三次方)
    public static int countOfRangeSumV1(int[] array, int lower, int upper) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = 0;
                for (int m = i; m <= j; m++) {
                    temp += array[m];
                }
                if (temp >= lower && temp <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    // 使用遍历的方式解决, 增加一个前缀和辅助数组， 时间复杂度为O(n的二次方)
    public static int countOfRangeSumV2(int[] array, int lower, int upper) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int len = array.length;
        int[] help = new int[len];
        // 根据array计算得到一个前缀和数组
        for (int i = 0; i < len; i++) {
            help[i] = help[Math.max(i - 1, 0)] + array[i];
        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp;
                if (i == j) {
                    temp = help[j];
                } else {
                    temp = help[j] - help[i];
                }
                if (temp >= lower && temp <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    // 改写归并排序完成统计的过程， 时间复杂底为O(n * logn)
    public static int countOfRangeSumV3(int[] array, int lower, int upper) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int preSize = array.length;
        int[] preSum = new int[preSize];
        for (int i = 0; i < preSize; i++) {
            preSum[i] = preSum[Math.max(0, i - 1)] + array[i];
        }

        return process(preSum, 0, preSize - 1, lower, upper);
    }

    public static int process(int[] sum, int left, int right, int lower, int upper) {
        if (left == right) {
            if (sum[left] >= lower && sum[left] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = left + (right - left) / 2;
        return process(sum, left, mid, lower, upper) +
                process(sum, mid + 1, right, lower, upper) +
                merge(sum, left, mid, right, lower, upper);
    }

    public static int merge(int[] sum, int left, int mid, int right, int lower, int upper) {
        int count = 0;
        int l = left; int r = left;
        for (int i = mid + 1; i <= right; i++) {
            int min = sum[i] - upper;
            int max = sum[i] - lower;
            while (l <= mid && sum[l] < min) {
                l++;
            }
            while (r <= mid && sum[r] <= max) {
                r++;
            }
            count += r - l;
        }

        int lp = left, rp = mid + 1;
        int index = 0;
        int helpSize = right - left + 1;
        int[] help = new int[helpSize];
        while (lp <= mid && rp <= right) {
            help[index++] = sum[lp] <= sum[rp] ? sum[lp++] : sum[rp++];
        }
        while (lp <= mid) {
            help[index++] = sum[lp++];
        }
        while (rp <= right) {
            help[index++] = sum[rp++];
        }
        for (int i = 0; i < helpSize; i++) {
            sum[left + i] = help[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = { 1, -1, -2, 3, 0, 0, 0 };
        int lower = -1, upper = 1;
        //int count = countOfRangeSumV1(array, lower, upper);
        int count1 = countOfRangeSumV2(array, lower, upper);
        int count2 = countOfRangeSumV3(array, lower, upper);
        System.out.println(count1);
        System.out.println(count2);
    }
}
