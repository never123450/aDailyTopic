package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/wiggle-subsequence/
 * 摆动序列
 * @author: xwy
 * @create: 19:31 2020/12/13
 **/

public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);

    }
}