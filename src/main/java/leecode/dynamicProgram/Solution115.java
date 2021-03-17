package leecode.dynamicProgram;

/**
 * @description: https://leetcode-cn.com/problems/distinct-subsequences/
 * 不同的子序列
 * @author: xwy
 * @create: 下午3:33 2021/3/17
 **/

public class Solution115 {

    /*
        s = "rabbbit",
        t = "rabbit"

     */

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int pre = 1;
            for (int j = 1; j <= n; j++) {
                int cur = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += pre;
                }
                pre = cur;
            }
        }
        return dp[n];
    }

    // --------------------------------------------------------------------

    /**
     * 动态规划
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct1(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    // --------------------------------------------------------------------

    /**
     * 暴力递归
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct2(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (t == null || t.length() == 0) {
            return 1;
        }

        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        int a = 0, b = 0;
        if (s.charAt(i) == t.charAt(j)) {
            // 选 i + 不选 i
            a = dfs(s, t, i + 1, j + 1) + dfs(s, t, i + 1, j);
        } else {
            // 不选 i
            b = dfs(s, t, i + 1, j);
        }
        return a + b;
    }


    // --------------------------------------------------------------------

    /**
     * 记忆递归
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct3(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (t == null || t.length() == 0) {
            return 1;
        }

        return dfs2(s, t, 0, 0, new Integer[s.length()][t.length()]);
    }

    private int dfs2(String s, String t, int i, int j, Integer[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        // 之前算过了，存在dp里呢，那就直接拿来用
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int a = 0, b = 0;
        if (s.charAt(i) == t.charAt(j)) {
            // 选 i + 不选 i
            a = dfs2(s, t, i + 1, j + 1, dp) + dfs2(s, t, i + 1, j, dp);
        } else {
            // 不选 i
            b = dfs2(s, t, i + 1, j, dp);
        }

        // 答案存进dp后再返回。让 dp ”记住”
        dp[i][j] = a + b;
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution115 solution115 = new Solution115();
        int i = solution115.numDistinct("rabbbit", "rabbit");
        System.out.println(i);
    }
}