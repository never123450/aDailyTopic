package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/remove-element/
 * 移除元素
 * @author: xwy
 * @create: 下午3:58 2021/4/19
 **/

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

    public int removeElement1(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        Solution27 solution27  = new Solution27();
        int[] nums = {3,2,2,3};
        int val = 3;
        int i = solution27.removeElement1(nums, val);
        System.out.println(i);
    }
}