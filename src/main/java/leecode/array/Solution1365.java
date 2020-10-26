package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * 有多少小于当前数字的数字
 * @author: xwy
 * @create: 21:14 2020/10/26
 **/

public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    sum++;
                }
            }
            result[i] = sum;
        }
        return result;
    }
}