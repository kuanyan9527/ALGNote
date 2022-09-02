package kuanyan.improve.xor;

import kuanyan.common.Common;

import java.util.HashSet;
import java.util.Set;

// 一个整型数组中只有一种数出现了K次，其余的数都出现了M次， 找到出现K次的数（M > 1, K < M）
// 要求空间复杂度O(1)， 时间复杂度O(N)
public class FIndKNumber {
    // 使用一个长度位32的数组temp， 记录所有数对应二进制位1的个数, temp[i] = M * x + K
    public static int process(int[] array, int K, int M) {
        int[] temp = new int[32];
        for (int i = 0, len = array.length; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                if ((array[i] & (1 << j)) != 0) {
                    temp[j] += 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (temp[i] % M != 0) {
                res += (1 << i);
            }
        }
        return res;
    }

    public static int[][] createTestArray(int maxValue, int maxLength) {
        int kNum = Common.randomRangeNumber(maxValue);
        int m;
        do {
            m = Common.randomRangeNumber(maxLength);
        } while (m <= 1);
        int k;
        do {
            k = Common.randomRangeNumber(maxLength);
        } while (k >= m || k < 1);
        int mNumTotal = Common.randomRangeNumber(maxLength);
        Set<Integer> mNumSet = new HashSet<>();
        while (mNumSet.size() < mNumTotal) {
            mNumSet.add(Common.randomRangeNumber(maxValue));
        }

        Integer[] mNumArray = new Integer[mNumSet.size()];
        mNumSet.toArray(mNumArray);
        int len = k + m * mNumSet.size();
        int[] res = new int[len];
        int current = 0;
        for (int i = 0; i < k; i++) {
            res[current] = kNum;
            current++;
        }
        for (int i = 0, l = mNumArray.length; i < l; i++) {
            for (int j = 0; j < m; j++) {
                res[current] = mNumArray[i];
                current++;
            }
        }
        int[] array = Common.shuffleArray(res);
        int[][] result = new int[3][];
        result[0] = array;
        result[1] = new int[] { k, m };
        result[2] = new int[] { kNum };

        return result;
    }

    public static void main(String[] args) {
        int maxValue = 100;
        int maxLength = 100;
        int total = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < total; i++) {
            int[][] testData = createTestArray(maxValue, maxLength);
            int[] array = testData[0];
            int k = testData[1][0];
            int m = testData[1][1];
            int kNUm = testData[2][0];
            int res = process(array, k, m);
            if (res != kNUm) {
                System.out.println("出错了");
                Common.printIntArray(array);
                System.out.println("res = " + res);
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static void main2(String[] args) {
        int[] array = { 5, 2, 4, 4, 2, 3, 4, 7, 7, 9, 5, 9, 7, 3, 7, 7, 7, 1, 2, 7, 1, 1, 9, 0, 0, 5, 3 };
        int kNum = process(array, 6, 3);
        System.out.println(kNum);
    }
}
