package leecode.array;

import java.util.Arrays;

/**
 * @description: https://leetcode-cn.com/problems/find-pivot-index/
 * 寻找数组的中心索引
 * @author: xwy
 * @create: 21:47 2021/1/29
 **/

public class Solution724 {
    public int pivotIndex(int[] nums) {

        // 2*n + nums[i] == sum
        int sum = Arrays.stream(nums).sum();
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * n + nums[i] == sum) {
                return i;
            }
            n += nums[i];
        }
        return -1;
    }


}