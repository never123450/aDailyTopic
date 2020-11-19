package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 * @author: xwy
 * @create: 18:45 2020/11/19
 **/

public class Solution283 {

    /**
     * 双指针
     * @param nums
     * left:(0 的尾部)交换完成的尾部, right:循环
     * @return
     */
    public int[] moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }

        return nums;
    }

    // 暴力
    public int[] moveZeroes1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
        while (index<nums.length){
            nums[index++]=0;
        }
        return nums;
    }


    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }


    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] ints = solution283.moveZeroes(new int[]{0, 1, 0, 3, 12});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}