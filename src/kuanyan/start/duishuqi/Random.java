package kuanyan.start.duishuqi;

public class Random {
    public static void main(String[] args) {
        // test1(0.6);
        // test2(0.5);
        // test3();
        test4();
    }

    // Math.random()会等概率返回[0, 1)之间的数
    // 对于任意给定的x（0<=x<1），再[0, x]上出现的概率为x的平方
    public static void test1(double x) {
        int total = 100000;
        int count = 0;
        for (int i = 0; i < total; i++) {
            if (xToXPow2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) total);
        System.out.println(Math.pow(x, 2));
    }

    public static double xToXPow2() {
        return Math.max(Math.random(), Math.random());
    }

    // Math.min
    public static void test2(double x) {
        int total = 100000;
        int count = 0;
        for (int i = 0; i < total; i++) {
            if (mathMin() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) total);
        System.out.println(1 - Math.pow((1 - x), 2));
    }

    public static double mathMin() {
        return Math.min(Math.random(), Math.random());
    }

    // 给定一个产生[1, 5]随机数的函数，在不借助其他函数的前提下，得到一个产生[1, 7]随机数的函数
    public static void test3() {
        int[] count = new int[50];
        int total = 100000;
        for (int i = 0; i < total; i++) {
            // count[random1_7()]++;
            count[randomA_bToRandomC_d(1, 5, 20, 29)]++;
        }

        for (int i = 0, len = count.length; i < len; i++) {
            System.out.println(i + "出现了：" + count[i] + "次");
        }
    }

    public static int random1_5() {
        return (int)(Math.random() * 5) + 1;
    }

    public static int random1_7() {
        int l = 3;
        int res;
        do {
            res = 0;
            for (int i = 0; i < l; i++) {
                int temp = to0or1();
                res += (temp << i);
            }
        } while (res > 6);

        return res + 1;
    }

    public static int to0or1() {
        int cur;
        do {
            cur = random1_5();
        } while (cur == 3);
        return cur < 3 ? 0 : 1;
    }

    // 给定一个产生[a, b]随机数的函数，在不借助其他函数的前提下，得到一个产生[c, d]随机数的函数
    static int num = -1;
    public static int randomA_bToRandomC_d(int a, int b, int c, int d) {
        if (num == -1) {
            num = (int) Math.ceil(Math.log(d) / Math.log(2));
        }
        int res;
        do {
            res = 0;
            for (int i = 0; i < num; i++) {
                res += ((randomTo0or1(a, b)) << i);
            }
        } while (res > (d - c));
        return res + c;
    }

    public static int randomA_b(int a, int b) {
        return (int) (Math.random() * b) + a;
    }

    public static int randomTo0or1(int a, int b) {
        int cur;
        int mid = (int) ((double) (a + b) / 2);
        do {
            cur = randomA_b(a, b);
        } while (cur == mid && mid == (double) (a + b) / 2);
        return cur > mid ? 1 : 0;
    }

    // 从0,1不等概率到0，1等概率
    public static void test4() {
        int total = 10000;
        int[] count = new int[2];
        for (int i = 0; i < total; i++) {
            count[noEqualToEqual()]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i + "出现了：" + count[i] + "次");
        }
    }

    public static int noEqualToEqual() {
        int cur;
        do {
            cur = noEqual01();
        } while (cur == noEqual01());
        return cur;
    }

    public static int noEqual01() {
        return Math.random() > 0.8 ? 1 : 0;
    }

}
