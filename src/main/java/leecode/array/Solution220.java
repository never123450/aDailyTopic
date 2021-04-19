package leecode.array;

import java.util.Arrays;

/**
 * @description: https://leetcode-cn.com/problems/contains-duplicate-iii/
 * 存在重复元素 III
 * @author: xwy
 * @create: 下午4:52 2021/4/19
 **/

public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j])<=t && Math.abs(i-j)<=k){
                    return true;
                }
                if (Math.abs(nums[i]-nums[j])>t){
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution220 solution220 = new Solution220();
        int[] nums = {1,5,9,1,5,9};
        int k = 2,t=3;
        boolean b = solution220.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }
}