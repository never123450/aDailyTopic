package leecode.slidingWindow;

/**
 * @description: https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 * 尽可能使字符串相等
 * @author: xwy
 * @create: 17:22 2021/2/8
 **/

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int l = 0, r = 0;
        while (r < n) {
            int abs = Math.abs(s.charAt(r) - t.charAt(r));
            if (maxCost - abs >= 0) {
                maxCost = maxCost - abs;
            }else {
                maxCost += Math.abs(s.charAt(l) - t.charAt(l));
                maxCost = maxCost - abs;
                l++;
            }
            r++;
        }
        return n-l;
    }

    public static void main(String[] args) {
        Solution1208 solution1208 = new Solution1208();
        String s = "abcd",t="bcdf"; int maxCost = 3;
        System.out.println(solution1208.equalSubstring(s,t,maxCost));
    }
}