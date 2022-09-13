package kuanyan.improve.recursion;

public class GetMax {
    public static int getMax(int[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("参数为null或数组长度为零");
        }
        if (array.length == 1) {
            return array[0];
        }
        return process(array, 0, array.length - 1);
    }

    public static int process(int[] array, int left, int right) {
        if (left == right) {
            return array[right];
        }
        int mid = left + (right - left) / 2;
        int leftMax = process(array, left, mid);
        int rightMax = process(array, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) throws Exception {
        int[] array = { 0, 5, -1, 7, 5, 3, 10, 9 };
        System.out.println(getMax(array));
    }
}
