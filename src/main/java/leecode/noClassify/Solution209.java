package leecode.noClassify;

/**
 * @description: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * <p>
 * 练习 ： 3  438  76
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author: xwy
 * @create: 11:51 AM 2020/3/1
 **/

public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {

        int left = 0, right = -1; // nums[l...r]为滑动窗口
        int sum = 0;
        int res = nums.length + 1;//最小连续数组的长度

        while (left < nums.length) {
            if (sum < s && right + 1 < nums.length) {
                right++;
                sum += nums[right];
            } else {
                sum -= nums[left];
                left++;
            }

            if (sum == s)
                res = Math.min(res, right - left + 1);
        }

        if (res == nums.length + 1)
            return 0;

        return res;
    }

    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        Solution209 solution209 = new Solution209();
        int res = solution209.minSubArrayLen(7,nums);
        System.out.println(res);
    }
}