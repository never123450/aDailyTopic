package leecode.binarySearch;

/**
 * @description: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 搜索选择排序数组
 * @author: xwy
 * @create: 8:17 PM 2020/4/26
 **/

public class Solution33 {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // 左边有序
                if (target >= nums[left] && target <= nums[mid]) {
                    // 目标在左边
                    right = mid-1;
                } else {
                    // 目标在右边
                    left = mid+1;
                }
            } else {
                // 右边有序
                if (target >= nums[mid] && target <= nums[right]) {
                    // 目标在右边
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = { 2,1};
        int target = 1;
        System.out.println(solution33.search(nums, target));
    }
}