package kuanyan.common;

public class Common {
    public static void printIntArray(int[] array) {
        for (int i = 0, len =array.length; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static void swapInArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] copyIntArray(int[] array) {
        int len = array.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = array[i];
        }
        return res;
    }
}
