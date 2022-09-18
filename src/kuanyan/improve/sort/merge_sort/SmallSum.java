package kuanyan.improve.sort.merge_sort;

// 小和问题
// 问题描述：给定一个数组，计算数组中所有元素左边比该元素小的数的累加和
public class SmallSum {
    public static int smallSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return process(array, 0, array.length - 1, 0);
    }

    public static int process(int[] array, int left, int right, int sum) {
        if (left == right) {
            return sum;
        }
        int mid = left + (right - left) / 2;
        return process(array, left, mid, sum) +
                process(array, mid + 1, right, sum) +
                merge(array, left, mid, right);
    }

    public static int merge(int[] array, int left, int mid, int right) {
        if (left == right) {
            return 0;
        }
        int sum = 0;
        int lp = left;
        int rp = Math.min((mid + 1), right);
        int helpLength = right - left + 1;
        int[] help = new int[helpLength];
        int index = 0;
        while (lp <= mid && rp <= right) {
            sum += array[lp] < array[rp] ? (right - rp + 1) * array[lp] : 0;
            help[index++] = array[lp] < array[rp] ? array[lp++] : array[rp++];
        }

        while (lp <= mid) {
            help[index++] = array[lp++];
        }

        while (rp <= right) {
            help[index++] = array[rp++];
        }

        for (int i = 0; i < helpLength; i++) {
            array[left + i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int array[] = { 6, 3, 2, 1, 6, 7 };
        int sum = smallSum(array);
        System.out.println(sum);
    }
}
