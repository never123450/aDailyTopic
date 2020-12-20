package leecode.string;

/**
 * @description: https://leetcode-cn.com/problems/find-the-difference/
 * 找不同
 * @author: xwy
 * @create: 19:54 2020/12/19
 **/

public class Solution389 {
    // 常规
    public char findTheDifference(String s, String t) {
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) < 0) {
                return chars[i];
            } else {
                s = s.replaceFirst(String.valueOf(chars[i]), "");
            }
        }
        return 0;
    }

    // 计数
    public char findTheDifference1(String s, String t) {
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            letter[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            letter[ch - 'a']--;
            if (letter[ch - 'a'] < 0) {
                return ch;
            }
        }
        return 0;
    }

    // 求和
    public char findTheDifference2(String s, String t) {
        int sc = 0, tc = 0;
        for (char c : s.toCharArray()) {
            sc+=c;
        }
        for(char c:t.toCharArray()){
            tc+=c;
        }
        return (char) (tc-sc);
    }

    // 异或,相同为 0,不同为 1
    public char findTheDifference3(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for(char c:t.toCharArray()){
            res ^=c;
        }
        return res;

    }

    public static void main(String[] args) {
        Solution389 solution389 = new Solution389();
        char theDifference = solution389.findTheDifference3("aa", "aaa");
        System.out.println(theDifference);

    }
}