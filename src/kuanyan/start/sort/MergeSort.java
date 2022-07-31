package kuanyan.start.sort;

// 归并排序
public class MergeSort {
    // 递归实现归并排序
    public static void mergeSort1(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        process1(array, 0, array.length -1);
    }

    public static void process1(int[] array, int left, int right) {
        if (right == left) {
            return;
        }
        int mid = left + (right - left) / 2; // (left + right) / 2可能会出现溢出
        process1(array, left, mid);
        process1(array, mid + 1, right);
        merge(array, left, mid , right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] tempArray = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            tempArray[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            tempArray[i++] = array[p1++];
        }
        while (p2 <= right) {
            tempArray[i++] = array[p2++];
        }
        for (int j = 0; j < tempArray.length; j++) {
            array[left + j] = tempArray[j];
        }
    }

    public static void mergeSort2() {

    }

    public static void main(String[] args) {
        int[] array = new int[]{ 0, 9, 1, 5, 7, 4, 8, 3, 2, 6 };
        mergeSort1(array);
        System.out.println(array);
    }
}
