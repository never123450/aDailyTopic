package leecode;

/**
 * @description: https://leetcode-cn.com/problems/sub-sort-lcci/
 * 部分排序 16.16
 * @author: xwy
 * @create: 20:03 2020/10/11
 **/

public class Solution16 {
    public int[] subSort(int[] array) {

        if (array.length == 0) return new int[]{-1, -1};

        // 从左扫描到右寻找逆序对(正序:逐渐变大)
        int max = array[0];
        // 用来记录最右边的那个逆序对的位置
        int r = -1;
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            if (v >= max) {
                max = v;
            } else {
                r = i;
            }
        }

        // 从右扫描到左寻找逆序对(正序:逐渐变小)
        int min = array[array.length - 1];
        // 用来记录最左边的那个逆序对的位置
        int l = -1;
        for (int i = array.length - 2; i >= 0; i--) {
            int v = array[i];
            if (v <= min) {
                min = v;
            } else {
                l = i;
            }
        }

        return new int[]{l, r};
    }
}