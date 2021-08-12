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
     *
     * @param nums left:(0 的尾部)交换完成的尾部, right:循环
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
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
        return nums;
    }


    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }


    // --------------------------------------------

    /**
     * @description: https://leetcode-cn.com/problems/move-zeroes/
     * 移动零
     * <p>
     * 27题   26题   80题
     * @author: xwy
     * @create: 4:20 PM 2020/2/27
     **/

    /*
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public void moveZeroes2(int[] nums) {
        int[] nonZero = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZero[j++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nonZero[i];
            System.out.print(nums[i] + " ");
        }
    }

    /*
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public void moveZeroes3(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /*
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public void moveZeroes4(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap2(k++, i, nums);
                } else {
                    k++;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private void swap2(int i, int k, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    /**
     * 遍历一遍
     *
     * @param nums
     * @return
     */
    public int[] moveZeroes5(int[] nums) {
        if (nums == null) return null;
        for (int i = 0, cur = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (cur != i) {
                nums[cur] = nums[i];
                nums[i] = 0;
            }
            cur++;
        }
        return nums;
    }

    //----------------------------------------------

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] ints = solution283.moveZeroes5(new int[]{1});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}