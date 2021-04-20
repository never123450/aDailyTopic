package leecode.string;

/**
 * @description: https://leetcode-cn.com/problems/implement-strstr/
 * 实现 strStr()
 * @author: xwy
 * @create: 下午3:42 2021/4/20
 **/

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        char[] main = haystack.toCharArray();
        char[] from = needle.toCharArray();
        if (main.length == from.length) {
            for (int i = 0; i < main.length; i++) {
                if (main[i] != from[i]) {
                    return -1;
                }
            }
            return 0;
        }
        for (int i = 0; i < main.length - from.length + 1; i++) {
            int j;
            for (j = 0; j < from.length; j++) {
                if (main[i + j] != from[j]) {
                    break;
                }
            }
            if (j == from.length) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        String haystack = "aaaaa";
        String needle = "bba";
        int i = solution28.strStr(haystack, needle);
        System.out.println(i);
    }
}