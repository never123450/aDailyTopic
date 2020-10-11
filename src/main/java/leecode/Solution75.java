package leecode;

/**
 * @description: https://leetcode-cn.com/problems/sort-colors/
 * 颜色分类
 * 练习：88 215
 * @author: xwy
 * @create: 8:38 PM 2020/2/27
 **/

public class Solution75 {
    public void sortColors(int[] nums) {

        int[] count = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        // 1. 计数排序
//        int index = 0;
//        for (int i = 0; i < count[0]; i++) {
//            nums[index++] = 0;
//        }
//        for (int i=0;i<count[1];i++){
//            nums[index++] = 1;
//        }
//        for (int i=0;i<count[2];i++){
//            nums[index++] = 2;
//        }

        // 上面简化为下面：
        // [2,0,2,1,1,0]
        int index = 0;
        for (int j = 0; j < count.length; j++) {
            for (int i = 0; i < count[j]; i++) {
                nums[index] = j;
                System.out.print(nums[index]);
                index++;
            }
        }

    }

    // 2.三路快排  时间复杂度：O(n) 空间复杂度 O(1)

    private void swap(int i, int k, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }


    public void sortColors1(int[] nums) {
        int zero = -1; // nums[0...zero]  == 0
        int two = nums.length; // nums[two...n-1]  == 2
        for (int i = 0; i < two; ) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2) {
                two--;
                swap(i, two, nums);
            } else {// nums[i]==0
                zero++;
                swap(zero, i, nums);
                i++;
            }
        }

    }

    public void sortColors3(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while (i <= r) {
            int v = nums[i];
            if (v == 0) {
                swap(i++, l++, nums);
            } else if (v == 1) {
                i++;
            } else {
                swap(i, r--, nums);
            }
        }
    }

    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution75.sortColors(nums);
    }

}