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
    public int findContentChildren3(int[] g, int[] s) {
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

    /**
     * @param
     * @param g
     * @param s
     * @return int
     * @Description 循环饼干 从小到大
     * @author xwy
     * @date 2022-07-22 下午8:25
     */
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int result = 0;
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && s[i] >= g[index]) {
                index++;
                result++;
            }
        }
        return result;
    }

    /**
     * @Description 循环人  从大到小
     * @author xwy
     * @date 2022-07-22 下午8:26
     * @param
     * @param g
     * @param s
     * @return int
     */
    public int findContentChildren(Integer[] g, Integer[] s) {
//        Arrays.sort(g, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        Arrays.sort(s, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length-1;
        int result = 0;
        for (int i = g.length-1; i >= 0; i--) {
            if (index >=0 && g[i] <= s[index]) {
                index--;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution455 solution455 = new Solution455();
        Integer[] g = new Integer[]{1,2,3};
        Integer[] s = new Integer[]{3};
        int contentChildren = solution455.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}