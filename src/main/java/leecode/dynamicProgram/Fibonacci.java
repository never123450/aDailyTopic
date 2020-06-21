package leecode.dynamicProgram;

/**
 * @description: 斐波那契数列
 * <p>
 * 动态规划：将原问题拆解成若干小问题，同时报存子问题的答案，使得每个子问题都只求解一次，最终获得原问题的答案
 * @author: xwy
 * @create: 8:09 AM 2020/3/19
 **/

public class Fibonacci {

    int num = 0;
    int[] memo;

    int fib(int n) {
        num++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        // 存在重复计算
//        return fib(n - 1) + fib(n - 2);
        //把结果存入memo中，减少重复计算 记忆化搜索
        if (memo[n] == -1)
            memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    // 自下而上的解决问题
    int fib2(int n) {
        memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;

        long start = System.nanoTime();
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            fibonacci.memo[i] = -1;
        }

        int fib = fibonacci.fib(n);
        long end = System.nanoTime();
        System.out.println("fib(" + n + ")=" + fib);
        System.out.println("time:" + (end - start) / Math.pow(10, -9));
        System.out.println("次数：" + fibonacci.num);
    }
}