package kuanyan.start;

/**
 * 给一个整数N，求1到N的阶乘和
 */
public class Factorial {
    public static void main(String[] args) {
        int sum = FSum(5);
        System.out.println(sum);
        sum = FSum2(5);
        System.out.println(sum);
    }

    public static int FSum(int num) {
        int sum = 0;
        int last = 1;
        for(int i = 1; i <= num; i++) {
            last *= i;
            sum += last;
        }
        return sum;
    }

    // 做结果对比
    public static int FSum2(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            int last = 1;
            for (int j = 1; j <= i; j++) {
                last *= j;
            }
            sum += last;
        }
        return sum;
    }
}
