package kuanyan.start.bit_operation;

// https://leetcode.com/problems/divide-two-integers
public class Arithmetic {
    public static int add(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return add(n1 ^ n2, ((n1 & n2) << 1));
    }

    public static int minus(int n1, int n2) {
        return add(n1, negNum(n2));
    }

    public static  int negNum(int num) {
        return add(~num, 1);
    }

    public static int multi(int n1, int n2) {
        int result = 0;
        while (n2 != 0) {
            if ((n2 & 1) != 0) {
                result = add(result, n1);
            }
            n1 = n1 << 1;
            n2 = n2 >>> 1;
        }
        return result;
    }

    public static int div(int n1, int n2) {
        int result = 0;
        int x = n1 < 0 ? negNum(n1) : n1;
        int y = n2 < 0 ? negNum(n2) : n2;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                result = add(result, 1 << i);
                x = minus(x, y << i);
            }
        }
        return (n1 ^ n2) < 0 ? negNum(result) : result;
    }

    public static int divide(int n1, int n2) {
        if (n1 == Integer.MIN_VALUE && n2 == Integer.MIN_VALUE) {
            return 1;
        } else if (n2 == Integer.MIN_VALUE) {
            return 0;
        } else if (n1 == Integer.MIN_VALUE) {
            if (n2 == add(~1, 1)) {
                return Integer.MAX_VALUE;
            } else {
                int temp = div(add(n1, 1), n2);
                return add(temp, div(minus(n1, multi(temp, n2)), n2));
            }
        } else {
            return div(n1, n2);
        }
    }

    public static void main(String[] args) {
//        System.out.println(add(-1, -1));
//        System.out.println(minus(-10, 8));
//        System.out.println(multi(-7, 3));
        System.out.println(divide(-7, -3));
    }
}
