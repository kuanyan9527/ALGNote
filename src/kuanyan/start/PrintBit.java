package kuanyan.start;

/**
 * 打印一个整数的32位二进制
 */
public class PrintBit {
    public static void main(String[] args) {
        print(10);
        print(Integer.MIN_VALUE);
        print(-1); // 负数的二进制等于它的绝对值取反+1
    }

    public static void print(int num) {
        StringBuilder bitStr = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            String bit = (num & (1 << i)) == 0 ? "0" : "1";
            bitStr.append(bit);
        }
        System.out.println(bitStr);
    }
}
