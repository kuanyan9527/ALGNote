package kuanyan.start.bit_operation;

import java.util.HashSet;

// 位图，使用一个long类型的每一位去存储数据。这样能够极大的节约存储空间
public class BitMap {
    private final long[] map;

    public BitMap(int maxValue) {
        map = new long[(maxValue >> 6) + 1];
    }

    public void add(int num) {
        map[num >> 6] |= (1L << (num & 63));
        // num >> 6 等效于 num / 64
        // num & 63 等效于 num % 64
    }

    public void delete(int num) {
        map[num >> 6] &= ~(1L << (num & 63)); // 使用异或会导致本来为0，操作完变成了1
    }

    public boolean contains(int num) {
        return (map[num >> 6] & (1L << (num & 63))) != 0;
    }

    public static void main(String[] args) {
        int maxValue = 1000;
        BitMap bitMap = new BitMap(maxValue);
        HashSet<Integer> hashSet = new HashSet<>();
        int total = 1000000;
        boolean failed = false;
        for (int i = 0; i < total; i++) {
            double random = Math.random();
            if (random < 0.33) {
                int value = (int) (Math.random() * maxValue) + 1;
                bitMap.add(value);
                hashSet.add(value);
            } else if (random < 0.66) {
                int value = (int) (Math.random() * maxValue) + 1;
                bitMap.delete(value);
                hashSet.remove(value);
            } else {
                int value = (int) (Math.random() * maxValue) + 1;
                if (hashSet.contains(value) != bitMap.contains(value)) {
                    System.out.println("出错了");
                    failed = true;
                }
            }
        }
        if (!failed) {
            System.out.println("成功");
        }
    }
}
