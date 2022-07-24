package leecode.BitOperation;

/**
 * @description: https://leetcode.cn/problems/single-number/
 * 136. 只出现一次的数字
 * @projectName:dataStructure
 * @see:leecode.BitOperation
 * @author:xwy
 * @createTime:2022-07-24 下午9:21
 * @version:1.0
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution136 solution136 = new Solution136();
        int[] nums = new int[]{4,1,2,1,2};
        int i = solution136.singleNumber(nums);
        System.out.println(i);
    }
}
