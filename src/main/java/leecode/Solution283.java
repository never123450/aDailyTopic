package leecode;

/**
 * @description: https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 * <p>
 * 27题   26题   80题
 * @author: xwy
 * @create: 4:20 PM 2020/2/27
 **/

public class Solution283 {
    /*
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public void moveZeroes(int[] nums) {
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
    public void moveZeroes1(int[] nums) {
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
    public void moveZeroes2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(k++, i, nums);
                } else {
                    k++;
                }

            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private void swap(int i, int k, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }


    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] nums = {0, 1, 0, 3, 12};

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        solution283.moveZeroes2(nums);
    }
}