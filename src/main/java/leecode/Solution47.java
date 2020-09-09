package leecode;

/**
 * @description: https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 礼物最大值
 * 动态规划
 * <p>
 * 64 最小路径和 62 不同路径
 * @author: xwy
 * @create: 9:59 PM 2020/9/8
 **/

public class Solution47 {

    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        // 第 0 行
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }
        // 第 0 列
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }

}