package kuanyan.improve.xor;

import kuanyan.common.Common;

import java.util.Arrays;

// 一个数组中只有两种数出现了奇数次，其余数都出现了偶数次，找到这两个数，要求空间复杂度O(1)
// 时间复杂度O(N²)
public class FinTwoNumber {
    public static int[] process(int[] array) {
        int len = array.length;
        int aXorB = 0;
        for (int i = 0; i < len; i++) {
            aXorB ^= array[i];
        }
        int aXorBRightOne = Common.getRightOne(aXorB);
        int a = 0;
        for (int i = 0; i < len; i++) {
            if ((array[i] & aXorBRightOne) != 0) {
                a ^= array[i];
            }
        }
        int b = aXorB ^ a;
        return new int[] {a, b};
    }

    public static int[][] createTestArray(int maxValue, int maxLength) {
        int len = Common.randomRangeNumber(maxLength) + 2;
        len = len % 2 == 0 ? len : len + 1;
        int[] array = new int[len];
        int odd1 = Common.randomRangeNumber(maxValue);
        int odd2;
        do {
            odd2 = Common.randomRangeNumber(maxValue);
        }while (odd1 == odd2);
        int odd1Num = 1;
        int odd2Num = 1;
        do {
            odd1Num = Common.randomRangeNumber(len);
        } while (odd1Num % 2 == 0);
        int currentTotal = 0;
        for (int j = currentTotal; j < currentTotal + odd1Num; j++) {
            array[j] = odd1;
        }
        currentTotal += odd1Num;
        do {
            odd2Num = Common.randomRangeNumber(len);
        } while (odd2Num % 2 == 0 || (odd1Num + odd2Num > len));
        for (int j = currentTotal; j < currentTotal + odd2Num; j++) {
            array[j] = odd2;
        }
        currentTotal += odd2Num;
        while (currentTotal < len) {
            int even;
            do {
                even = Common.randomRangeNumber(maxValue);
            } while (even == odd1 || even == odd2);
            int evenNum;
            do {
                evenNum = Common.randomRangeNumber(len - odd1Num - odd2Num + 1);
            } while (evenNum % 2 != 0 || (currentTotal + evenNum) > len);
            for (int j = currentTotal; j < currentTotal + evenNum; j++) {
                array[j] = even;
            }
            currentTotal += evenNum;
        }
        int[][] result = new int[2][];
        result[0] = array;
        result[1] = new int[]{ odd1, odd2 };
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
            int[] odds = testData[1];
            int[] res = process(array);
            if (!(res[0] == odds[0] || res[0] == odds[1]) && (res[1] == odds[0] || res[1] == odds[1])) {
                System.out.println("出错了");
                Common.printIntArray(array);
                System.out.print("res");
                Common.printIntArray(res);
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static void main2(String[] args) {
        int[] array = { 1, 2, 3, 3, 4, 4 };
        int[] res = process(array);
        Common.printIntArray(res);
    }
}
