package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 删除有序数组中的重复项 二
 * @author: xwy
 * @create: 下午3:39 2021/4/6
 **/

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        int [] nums = {0,0,1,1,1,1,2,3,3};
        int i = solution80.removeDuplicates1(nums);
        System.out.println(i);
    }





    /**
     * 这一类型的通用解法
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) nums[u++] = x;
        }
        return u;
    }



}