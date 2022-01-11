package leecode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
 * 练习：438 76 1143 32 1048
 * @author: xwy
 * @create: 10:34 PM 2020/3/2
 **/

public class Solution3 {

    /**
     * 使用滑动窗口
     *
     * @param s
     * @return
     */
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

    /**
     * 使用 hashSet
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * @Description  类似动态规划
     * @author xwy
     * @date 11/1/2022 下午8:53
     * @param
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        // pi 是 s[i] 字符上一次出现的位置
        // li 是以 s[i-1] 字符结尾的最长不重复子串的开始索引(最左索引)
        if (s == null) return 0;
        char[] chars = s.toCharArray();

        // 用来保存每一个字符上一次出现的位置
        Map<Character, Integer> prevIndex = new HashMap<>();
        prevIndex.put(chars[0], 0);

        // 以 i-1 位置字符结尾的最长不重复子串的开始索引(最左索引)
        int li = 0;
        int max = 1;
        for (int i = 0; i < chars.length; i++) {
            // i位置字符上一次出现的位置
            Integer pi = prevIndex.get(chars[i]);
            if (pi != null && li <= pi) {
                li = pi + 1;
            }
            // 存储这个字符出现的位置
            prevIndex.put(chars[i], i);
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }
        return max;
    }


}