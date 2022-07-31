package kuanyan.start.sort;

// 快速排序
public class QuickSort {
    public static void quickSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        process(array, 0, array.length - 1);
    }

    public static void process(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int la = -1;
        int ma = right;
        int p = array[right];
        int current = 0;
        while (current < ma) {
            if (array[current] < p) {
                swap(array, la + 1, current);
                current++;
                la++;
            } else if (array[current] > p) {
                swap(array, current, ma - 1);
                ma--;
            } else {
                current++;
            }
        }
        swap(array, ma, right);
        process(array, left, la);
        process(array, ma + 1, right);
    }

    public static void swap(int[] array, int x1, int x2) {
        if (x1 >= x2) {
            return;
        }
        int temp = array[x1];
        array[x1] = array[x2];
        array[x2] = temp;
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 0, 9, 6, 1, 5, 6, 7, 4, 8, 3, 2, 6, 1, 4, 1, 8, 5, 10 , 7, 5, 3, 66, 2 };
        quickSort(array);
        printArray(array);
    }
}
