package leecode.slidingWindow;

/**
 * @description: https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 子数组最大平均数 1
 * @author: xwy
 * @create: 08:43 2021/2/5
 **/

public class Solution643 {
    /**
     * 滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0d;
        int n = nums.length;

        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }

        if (n == k) {
            return sum / k;
        }

        double res = sum;
        for (int i = 1; i < nums.length; i++) {
            if (k + i <= n) {
                sum = sum - nums[i - 1] + nums[k + i - 1];
                res = Math.max(res, sum);
            } else {
                return res / k;
            }
        }
        return res / k;
    }

    public static void main(String[] args) {
        Solution643 solution643 = new Solution643();
        int [] nums = {1,12,-5,-6,50,3} ; int k=4;
        double maxAverage = solution643.findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }
}