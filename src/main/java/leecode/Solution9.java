package leecode;

/**
 *
 * @description: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
 * 练习：438 76
 *
 * @author: xwy
 *
 * @create: 10:34 PM 2020/3/2
**/

public class Solution9 {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[128];
        int left = 0, right = -1;//滑动窗口为s[l...r]
        int res = 0; // 满足最长子串长度
        while (left < s.length()) {
            if (right + 1 < s.length() && freq[s.charAt(right + 1)] == 0) {
                right++;
                freq[s.charAt(right)]++;
            } else {
                freq[s.charAt(left)]--;
                left++;
            }
            res = Math.max(right - left + 1, res);
        }
        return res;
    }
}