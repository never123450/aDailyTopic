package leecode.array;

import java.util.Arrays;

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

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return void
     * @Description 准备一个临时变量
     * @author xwy
     * @date 11/3/2022 下午9:06
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];
        int mi = 0, ni = 0;
        // 注意顺序不能颠倒
        for (int i = 0; i < m + n; i++) {
            if (mi >= m) {
                temp[i] = nums2[ni++];
            } else if (ni >= n) {
                temp[i] = nums1[mi++];
            } else if (nums1[mi] < nums2[ni]) {
                temp[i] = nums1[mi++];
            } else {
                temp[i] = nums2[ni++];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = temp[i];
        }
    }

    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return void
     * @Description 不使用临时数组，从后往前比较并存入
     * @author xwy
     * @date 11/3/2022 下午9:44
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {

    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        solution88.merge2(num1, m, num2, n);
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i]);
        }
    }

}