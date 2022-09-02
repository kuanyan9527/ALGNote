package kuanyan.common;

import java.util.*;

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

    public static int[] randomArray(int maxValue, int maxLength) {
        int length = randomRangeNumber(maxLength);
        int[] res = new int[length];
        for (int j = 0; j < length; j++) {
            res[j] = randomRangeNumber(maxValue);
        }
        return res;
    }

    public static int randomRangeNumber(int max) {
        return (int) (Math.random() * max);
    }

    public static boolean compareArrayEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        int len1 = arr1.length;
        int len2 =arr2.length;
        if (len1 != len2) {
            return false;
        }
        for(int i = 0; i < len1; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] shuffleArray(int[] array) {
        List<Integer> list = Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new));
        Collections.shuffle(list);
        return Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }

    // 将一个数最右侧的1提取出来
    public static int getRightOne(int num) {
        return num & (-num);
    }
}
