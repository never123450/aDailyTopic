package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/rotate-array/
 * 旋转数组
 * @author: xwy
 * @create: 16:13 2021/1/8
 **/

public class Solution189 {


    /**
     * 方法一: 暴力
     */
    private void rotate(int[] nums, int k) {
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % (nums.length);
            n[index] = nums[i];
        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = n[i];
//        }
        System.arraycopy(n, 0, nums, 0, nums.length);
    }

    /**
     * 反转数组
     *
     * @param nums
     * @param k
     */
    private void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution189.rotate2(nums, k);
//        solution189.reverse(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        // [5,6,7,1,2,3,4]
    }

}