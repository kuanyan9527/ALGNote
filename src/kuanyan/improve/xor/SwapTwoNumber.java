package kuanyan.improve.xor;

// 在不额外申请内存的情况加交换两个数
public class SwapTwoNumber {
    public static void main(String[] args) {
        int a = 10;
        int b = 6;
        System.out.println("a = " + a + ",b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + ",b = " + b);
    }
}
