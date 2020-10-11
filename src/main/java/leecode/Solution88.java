package leecode;

/**
 * @description: https://leetcode-cn.com/problems/merge-sorted-array/
 * 合并两个有序数组
 * @author: xwy
 * @create: 17:16 2020/10/11
 **/

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = nums1.length - 1;
        while (i2 >= 0) {
            if (i1 >= 0 && nums2[i2] < nums1[i1]) {
                nums1[cur--] = nums1[i1--];
            } else { // i1<0 || nums2[i2] >= nums1[i1]
                nums1[cur--] = nums2[i2--];
            }
        }

    }
}