package kuanyan.improve.xor;

import kuanyan.common.Common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 一组数中只有一种数出现了奇数次，其他所有数都出现了偶数次，找出这个出现了奇数次的数, 要求空间复杂度为O(1)
// 时间复杂度O(N)
// 空间复杂度O(1)
public class FindOnlyNumber {
    public static int process(int[] array) {
        int num = 0;
        for (int i = 0, len = array.length; i < len; i++) {
            num ^= array[i];
        }
        return num;
    }

    public static int[] createTestArray(int[] array, int maxValue, int maxLength) {
        int len = array.length;
        int oddNum = Common.randomRangeNumber(maxValue);
        int odd = 1;
        do {
            odd = Common.randomRangeNumber(maxLength / 2 + 1);
        } while (odd % 2 == 0 || odd > len);
        for (int j = 0; j < odd; j++) {
            array[j] = oddNum;
        }
        int currentTotal = odd;
        while (currentTotal < len) {
            int eventNum = 0;
            do {
                eventNum = Common.randomRangeNumber(maxValue);
            } while (eventNum == oddNum);
            int event = 0;
            do {
                event = Common.randomRangeNumber(maxLength / 2);
            } while (event % 2 != 0 || (currentTotal + event) > len);
            for (int j = currentTotal; j < len; j++) {
                array[j] = eventNum;
            }
            currentTotal += event;
        }
        for (int j = 0; j < 10; j++) {
            array = Common.shuffleArray(array);
        }
        return array;
    }

    public static int testProcess(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = array.length; i < len; i++) {
            int key = array[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int res = 0;
        for (int key: map.keySet()) {
            if (map.get(key) % 2 != 0) {
                res = key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int maxValue = 100;
        int maxLength = 100;
        int total = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < total; i++) {
            int len = Common.randomRangeNumber(maxLength);
            len = len % 2 == 0 ? len + 1 : len;
            int[] array = new int[len];
            array = createTestArray(array, maxValue, maxLength);
            int num = process(array);
            if (num != testProcess(array)) {
                System.out.println("出错了");
                Common.printIntArray(array);
                System.out.println("num = " + num);
                break;
            }
        }
        System.out.println("测试结束");

    }

    public static void main2(String[] args) {
        int[] array = { 1, 1, 1, 2, 2, 2, 2, 5, 5, 6, 6, 6, 6 };
        int num = process(array);
        System.out.println(num);
        num = testProcess(array);
        System.out.println(num);
    }
}
