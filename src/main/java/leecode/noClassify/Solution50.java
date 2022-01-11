package leecode.noClassify;

/**
 * @description: https://leetcode-cn.com/problems/powx-n/
 * Pow(x, n)
 * @author: xwy
 * @create: 2:32 下午 2020/9/24
 **/

public class Solution50 {
    /**
     * 解法一:将 n 个 x 相乘 (时间复杂度O(n) 空间复杂度 O(1) )
     * 解法二:快速幂(分治) (时间复杂度O(logn) 空间复杂度 O(1) 递归空间复杂度O(logn))
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        // 是否为奇数
        boolean odd = (n & 1) == 1;
        double half = myPow(x, n >> 1);
        half *= half;
        // 是否为负数
        // x = (n < 0) ? (1 / x) : x;
        return odd ? (half * x) : half;
    }

    /**
     * 非递归
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        double res = 1.0;
        boolean neg = n < 0;
        long y = neg ? -((long)n) : n;
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一位二进制为 1
                res *= x;
            }
            x *= x;
            // 舍弃最后一个二进制位
            y >>= 1;
        }
        return neg ? (1 / res) : res;
    }

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double v = solution50.myPow(4, 2);
        System.out.println(v);
    }
}