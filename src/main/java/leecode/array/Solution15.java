package leecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/3sum/
 * 三数之和
 * @author: xwy
 * @create: 10:05 上午 2020/9/24
 **/

public class Solution15 {
    // 左右夹击
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        // 排序
        Arrays.sort(nums);

        int lastIdx = nums.length - 3;
        int lastR = nums.length - 1;
        for (int i = 0; i <= lastIdx; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = lastR, remain = -nums[i];
            while (l < r) {
                int sumLr = nums[l] + nums[r];
                if (sumLr == remain) {
                    res.add(Arrays.asList(nums[l], nums[i], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sumLr < remain) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}