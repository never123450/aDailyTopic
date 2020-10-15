package leecode;

/**
 * @description: https://leetcode-cn.com/problems/valid-anagram/
 * 有效字母异位词
 * @author: xwy
 * @create: 9:28 PM 2020/4/26
 **/

public class Solution242 {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            c[t.charAt(i) - 'a']--;
            if (c[t.charAt(i) - 'a'] < 0) return false;
        }

        return true;
    }
}