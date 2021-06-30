package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/non-decreasing-array/
 * 非递减数列
 * @author: xwy
 * @create: 09:40 2021/2/7
 **/

public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        // 需要满足 num[i]<=num[i+1]
        // 如果 num[i]>num[i+1] 出现 1 次以上都不满足条件
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                count++;
                if (count > 1) {
                    return false;
                }

                // 修改第 i 个元素为 y
                nums[i] = y;
                // i 分别和 i 的前一个和后一个比较
                boolean a = a(i, nums);

                // 还原第 i 个元素
                nums[i] = x;

                // 修改第 i+1 个元素为 x
                nums[i+1] = x;
                // i+1 分别和 i+1 的前一个和后一个比较
                boolean b = a(i+1, nums);

                // 当他们同时为 false 时,就为 false
                if (b==false&&a==false){
                    return false;
                }
                nums[i+1] = y;
            }
        }
        return true;
    }

    /**
     * 分别和 i 的前一个和后一个比较
     * @param i
     * @param nums
     * @return
     */
    boolean a(int i,int[] nums){
        if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
            return false;
        }
        if (i + 1 < nums.length && nums[i ] > nums[i + 1]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution665 solution665 = new Solution665();
        int[] nums = {4, 2, 3}; //true
//        int[] nums = {3, 4, 2, 3};//false
//        int[] nums = {5, 7, 1, 8};// true
        boolean b = solution665.checkPossibility(nums);
        System.out.println(b);
    }
}