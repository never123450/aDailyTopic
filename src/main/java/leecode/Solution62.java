package leecode;

/**
 * @description: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 剑指 Offer 62. 圆圈中最后剩下的数字 (编号从 0 开始)
 * @author: xwy
 * @create: 1:19 下午 2020/9/29
 **/

public class Solution62 {
    /**
     * 递归
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        return (n == 1) ? 0 : (f(n - 1, m) + m) % n;
    }


    /**
     * 非递归
     *
     * @param n n 个数字
     * @param m 每次删除第 m 个
     * @return
     */
    public int lastRemaining1(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
    
}