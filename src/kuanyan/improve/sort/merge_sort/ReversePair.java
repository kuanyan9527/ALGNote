package kuanyan.improve.sort.merge_sort;

// 找出数组中逆序对的总个数
public class ReversePair {
    public static int reversePair(int[] array) {
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
        int lp = left, rp = mid + 1;
        int helpSize = right - left + 1;
        int[] help = new int[helpSize];
        int index = 0;
        while (lp <= mid && rp <= right) {
            sum = array[lp] < array[rp] ? sum : sum + rp - mid;
            help[index++] = array[lp] < array[rp] ? array[lp++] : array[rp++];
        }

        while (lp <= mid) {
            sum++;
            help[index++] = array[lp++];
        }

        while (rp <= right) {
            help[index++] = array[rp++];
        }

        for(int i = 0; i < helpSize; i++) {
            array[left + i] = help[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 4, 5, 1, 2, 3 };
        int total = reversePair(array);
        System.out.println(total);
    }
}
