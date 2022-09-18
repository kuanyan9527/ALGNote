package kuanyan.improve.sort.merge_sort;

// 找出数组中一个数num > 右边数 * 2的总总个数
public class BiggerThanRightTwice {
    public static int biggerThanRightTwice(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return process(array, 0, array.length - 1);
    }

    public static int process(int[] array, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return process(array, left, mid) +
                process(array, mid + 1, right) +
                merge(array, left, mid, right);
    }

    public static int merge(int[] array, int left, int mid, int right) {
        if (left == right) {
            return 0;
        }
        int res = 0;
        int windowR = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (windowR <= right && array[i] > array[windowR] * 2) {
                windowR++;
            }
            res += windowR - mid - 1;
        }
        int lp = left, rp = mid + 1;
        int index = 0;
        int helpSize = right - left + 1;
        int[] help = new int[helpSize];
        while (lp <= mid && rp <= right) {
            help[index++] = array[lp] <= array[rp] ? array[lp++] : array[rp++];
        }
        while (lp <= mid) {
            help[index++] = array[lp++];
        }
        while (rp <= right) {
            help[index++] = array[rp++];
        }
        for (int i = 0; i < helpSize; i++) {
            array[left + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = { 6, 7, 1, 3, 2, 0 };
        int total = biggerThanRightTwice(array);
        System.out.println(total);
    }
}
