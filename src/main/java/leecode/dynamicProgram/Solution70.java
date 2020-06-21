package leecode.dynamicProgram;

/**
 * @description: https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
 * 爬楼梯
 *
 * 练习：120 64 343
 * @author: xwy
 * @create: 9:28 AM 2020/3/19
 **/

public class Solution70 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}