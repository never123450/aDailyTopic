package leecode.noClassify;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 礼物最大值
 * 动态规划
 * 可以利用 46 题的方法解
 * <p>
 * 64 最小路径和 62 不同路径
 * @author: xwy
 * @create: 9:59 PM 2020/9/8
 **/

public class Solution47 {

    // -------------------剑指 offer 47题------------------------------------

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

    /**
     * 优化
     *
     * @param grid
     * @return
     */
    public int maxValue1(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 第 0 列
        for (int row = 1; row < rows; row++) {
            grid[row][0] += grid[row - 1][0];
        }

        // 第 0 行
        for (int col = 1; col < cols; col++) {
            grid[0][col] += grid[0][col - 1];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                grid[row][col] += Math.max(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[rows - 1][cols - 1];
    }


    // -------------------------正常 47 题------------------------------
    // https://leetcode-cn.com/problems/permutations-ii/

    private List<List<Integer>> list;
    private int[] nums;
    private boolean[] used1;
    private int[] result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        result = new int[nums.length];
        used1 = new boolean[nums.length];
        if (nums.length == 0) return list;
        this.nums = nums;
        dfs(0);
        return list;
    }

    // 值利用一个数组,反复交换位置
    // 0号位置分别和 0,1,2 号位置进行交换    让 1 号位置分别和1,2 号位置进行交换   让 2 号位置和 2 号位置进行交换
    private void dfs(int idx) {
        if (idx == nums.length) {
            List<Integer> resultList = new ArrayList<>();
            for (int value : nums) {
                resultList.add(value);
            }
            // 去重
//            if (!list.contains(resultList)){
//                list.add(resultList);
//            }
            list.add(resultList);
            return;
        }

        // 枚举这一层所有可以做出的选择
        for (int i = idx; i < nums.length; i++) {
            if (isRepeat(nums, idx, i)) continue;
            result[i] = nums[i];
            swap(idx, i);
            dfs(idx + 1);
            swap(idx, i);
        }
    }

    private boolean isRepeat(int[] nums, int idx, int i) {
        for (int j = idx; j < i; j++) {
            if (nums[j] == nums[i]) return true;
        }
        return false;
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        Solution47 solution47 = new Solution47();
        List<List<Integer>> lists = solution47.permuteUnique(new int[]{1, 2, 3, 1});
        System.out.println(lists);

    }

}