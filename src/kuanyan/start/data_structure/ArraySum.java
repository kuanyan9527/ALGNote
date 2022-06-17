package kuanyan.start.data_structure;

public class ArraySum {
    public static int[][] structure = null;
    public static int[] preSum = null;

    public static void main(String[] args) {
        int[] arr = { 3, 4,2, 1, 6,7, 8 };

        // 计算数组arr从l到r的累加和
        System.out.println(f1(arr, 0, 2));

        System.out.println(f2(arr, 0, 2));
    }

    // 将计算每种可能性的结果计算出来并存入一张表中，需要时直接根据下表拿结果
    // 这种解法再数据量不大且操作特别频繁的时候是首选
    public static int f1(int[] arr, int l, int r) {
        if (l > r || l < 0 || r > arr.length - 1) {
            return -1;
        }

        if (structure == null) {
            structure = createStructure(arr);
        }
        return structure[l][r];
    }

    public static int[][] createStructure(int[] arr) {
        int len = arr.length;
        int[][] structure = new int[len][];
        for (int i = 0; i < len; i++) {
            int [] temp = new int[len];
            for (int j = 0; j < len; j++) {
                temp[j] = structureItem(arr, i, j);
            }
            structure[i] = temp;
        }
        return structure;
    }

    public static int structureItem(int[] arr, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // 前缀和3，计算时需要按下标取值，并做减法
    public static int f2(int[] arr, int l, int r) {
        if (l > r || l < 0 || r > arr.length - 1) {
            return -1;
        }

        if (preSum == null) {
            preSum = createPreSum(arr);
        }

        return l == 0 ? preSum[r] : preSum[r] - preSum[l - 1];
    }

    public static int[] createPreSum(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = structureItem(arr, 0, i);
        }
        return res;
    }
}
