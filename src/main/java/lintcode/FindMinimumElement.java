package lintcode;

/**
 * @description: https://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array/description
 * @create: 2019年04月02日10:52:04
 **/

public class FindMinimumElement {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            //找到第一个左边大于右边的
            if (nums[start] > nums[++start]) {
                System.out.println("start:  " + start + "  nums[start]:  " + nums[start]);
                return nums[start];
            }
        }
        return nums[0];
    }


    public static void main(String[] args) {
        int[] nums = {6,1,2,3,4,5};
        FindMinimumElement findMinimumElement = new FindMinimumElement();
        System.out.println(findMinimumElement.findMin(nums));
    }

}