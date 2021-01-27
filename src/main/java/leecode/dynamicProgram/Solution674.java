package leecode.dynamicProgram;

/**
 * @description: https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 最长连续递增序列
 * @author: xwy
 * @create: 21:30 2021/1/25
 **/

public class Solution674 {

    /**
     * 滑动数组
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        int currentLen = 1;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 1;
            }
        }
        return maxLen;
    }

    /**
     * 动态规划
     * dp[i]含义：必须以 i 位置结尾的子数组中，最长递增子数组的长度是多少。
     * dp[i] = nums[i] > nums[i-1] ? dp[i-1] + 1 : 1;
     * ans = max { dp[i] }
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        /**
         * pre表示dp[i-1]: 必须以i-1位置结尾的递增子数组长度
         */
        int pre = 1;
        int ans = pre;
        for (int i = 1; i < nums.length; i++) {
            int cur = 1;
            if (nums[i] > nums[i - 1]) {
                cur += pre;
            }
            ans = Math.max(ans, cur);
            pre = cur;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution674 solution674 = new Solution674();
        int lengthOfLCIS = solution674.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(lengthOfLCIS);
    }
}