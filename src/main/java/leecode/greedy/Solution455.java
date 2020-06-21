package leecode.greedy;

import java.util.Arrays;

/**
 * @description: https://leetcode-cn.com/problems/assign-cookies/
 * <p>
 * 贪心算法
 *
 * 练习：392
 * @author: xwy
 * @create: 9:40 AM 2020/3/21
 **/

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int si = s.length - 1, gi = g.length - 1;
        int res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
                gi--;
            } else {
                gi--;
            }
        }
        return res;
    }
}