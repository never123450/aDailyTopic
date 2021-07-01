package leecode.array;

/**
 * @description: LCP 07. 传递信息
 * https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * @author: xwy
 * @create: 下午3:03 2021/7/1
 **/

public class Solution07 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
}