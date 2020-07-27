package xiaomage;

/**
 * @description: 斐波那契数列
 * @author: xwy
 * @create: 9:02 AM 2020/7/12
 **/

public class Fibonacci {

    /**
     * 效率低下，有大量重复计算
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n < 2) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 0 1 2 3 4
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n < 2) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n-1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(fib2(20));
    }

}