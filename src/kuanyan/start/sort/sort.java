package kuanyan.start.sort;

public class sort {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 6, 3, 9, 4, 7, 8 };

        // 将数组按照从大到小的顺序排列
        // selectSort(arr);
        // bubbleSort(arr);
        insertSort(arr);
        print(arr);
    }

    /**
     * 选择排序
     * 默认选择i位置的值位最小值，依次向后查找比i位置的值更小的值，最后交换
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }

        for (int i = 0, len = arr.length; i < len; i++) {
            int minValueIndex = i;
            for (int j = i; j < len; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j , j + 1);
                }
            }
        }
    }

    /**
     * 插入排序，让前n个元素有序，如此循环
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }

        for (int i = 1, len = arr.length; i < len; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j , j - 1);
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
