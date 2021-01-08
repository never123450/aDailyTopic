package leecode.noClassify;

/**
 * @description: https://leetcode-cn.com/problems/reverse-integer/
 * 整数反转
 * @author: xwy
 * @create: 10:54 上午 2020/10/3
 **/

public class Solution7 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int) res;
    }

    public int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            int prevRes = res;
            res = prevRes * 10 + x % 10;
            if ((res - x % 10) / 10 != prevRes) return 0;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(1234));
    }
}