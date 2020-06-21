package leecode.dynamicProgram;

/**
 * @description:https://leetcode-cn.com/problems/integer-break/submissions/
 *
 * 练习：279 91 62 63
 * @author: xwy
 * @create: 9:49 AM 2020/3/19
 **/

public class Solution343 {
    public int integerBreak(int n) {
        return breakInteger(n);
    }

    // 将n进行分割（至少分割2部分），可以获得的最大乘积
    private int breakInteger(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        if (n == 1)
            return 1;

        if (memo[n] != -1)
            return memo[n];

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            // i+(n-i)
            res = Math.max(Math.max(res, i * breakInteger(n - i)), i * (n - i));
        }
        memo[n] = res;
        return res;
    }

    public int integerBreak2(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解memo[i]
            for (int j = 1; j <= i - 1; j++) {
                // j+(i-j)
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }
        return memo[n];
    }
}