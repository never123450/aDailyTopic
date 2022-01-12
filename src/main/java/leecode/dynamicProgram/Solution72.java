package leecode.dynamicProgram;

/**
 * @description: https://leetcode-cn.com/problems/edit-distance/
 * 编辑距离 将 word1 转换成 word2 所使用的最少操作数 。
 * 小马哥 第三季 第二集
 * @author: xwy
 * @create: 4:57 下午 2020/9/10
 **/

public class Solution72 {

    /**
     * 动态规划
     * dp[i][j] 表示s1[0,i) 转化成 s2[0,j)的最少操作数
     * 1.先删除s1[0,i)的最后一个字符得到 s1[0,i-1),然后由 s1[0,i-1)转化成 s2[0,j)
     * 此时 dp[i][j] = 1+dp[i-1][j]
     * 2.先由 s1[0,i]转换成s2[0,j-1) ,然后在最后插入字符s2[j-1],得到s2[0,j)
     * 此时 dp[i][j] = 1+dp[i][j-1]
     * 3.如果 s1[i-1]!=s1[j-1],先由 s1[0,i-1]转换成 s2[0,j-1],然后将 s1[i-1] 替换成 s2[j-1]
     * 此时 dp[i][j] = dp[i-1][j-1]+1
     * 4.如果 s1[i-1]==s2[j-1] ,由 s1[0,i-1) 转换为 s2[0,j-1) 后不做任何操作
     * 此时dp[i][j] = dp[i-1][j-1]
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] dp = new int[cs1.length + 1][cs2.length + 1];

        // 有一个字符串为空串
        if (cs1.length * cs2.length == 0)
            return cs1.length + cs2.length;

        // 第 0 列
        for (int i = 0; i <= cs1.length; i++) {
            dp[i][0] = i;
        }

        // 第 0 行
        for (int i = 0; i < cs2.length; i++) {
            dp[0][i] = i;
        }

        // 其他行其他列
        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                int top = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                int leftTop = dp[i - 1][j - 1];
                if (cs1[i - 1] != cs2[j - 1]) {
                    leftTop++;
                }
                dp[i][j] = Math.min(Math.min(top, left), leftTop);
            }
        }

        return dp[cs1.length][cs2.length];
    }

    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        int i = solution72.minDistance("horse", "ros");
        System.out.println(i);
    }
}