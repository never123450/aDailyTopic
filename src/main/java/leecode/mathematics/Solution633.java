package leecode.mathematics;

/**
 * @description: https://leetcode-cn.com/problems/sum-of-square-numbers/
 * 平方数之和
 * @author: xwy
 * @create: 下午4:58 2021/4/28
 **/

public class Solution633 {


    public boolean judgeSquareSum(int c) {
        int j = (int) Math.sqrt(c);
        int i = 0;
        while (i <= j) {
            int total = i * i + j * j;
            if (total > c) {
                j = j - 1;
            } else if (total < c) {
                i = i + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution633 solution633 = new Solution633();
        boolean b = solution633.judgeSquareSum1(5);
        System.out.println(b);
    }
}