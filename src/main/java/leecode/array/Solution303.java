package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 区域和检索 - 数组不可变
 * @author: xwy
 * @create: 下午2:42 2021/3/16
 **/

public class Solution303 {

//    int[] sum;
//
//    public Solution303(int[] nums) {
//        sum = new int[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            sum[i + 1] = sum[i] + nums[i];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return sum[j + 1] - sum[i];
//    }

    int[] temp;

    public Solution303(int[] nums) {
        temp = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j ; k++) {
            sum+=temp[k];
        }
        return sum;
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

}