package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 删除有序数组中的重复项
 * @author: xwy
 * @create: 下午3:55 2021/4/6
 **/

public class Solution26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int [] nums = {1,1,2};
        System.out.println(solution26.removeDuplicates(nums));
    }
}