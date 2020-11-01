package leecode.string;

/**
 * @description: https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 * 最大单词长度乘积
 * @author: xwy
 * @create: 10:41 2020/11/1
 **/

public class Solution318 {
    // 暴力法
    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasCommonWords(words[i], words[j])) {
//              if (hasCommonWords1(words[i], words[j])) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    private boolean hasCommonWords(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(String.valueOf(s1.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    // 位操作
    private boolean hasCommonWords1(String s1, String s2) {
        int bitmark1 = 0;
        int bitmark2 = 0;
        for (char c : s1.toCharArray()) {
            bitmark1 |= 1 << (c - 'a');
        }
        for (char c : s2.toCharArray()) {
            bitmark2 |= 1 << (c - 'a');
        }
        return (bitmark1 & bitmark2) == 0;
    }

    // 位掩码+预计算
    public int maxProduct1(String[] words) {
        int result = 0;
        int[] marks = new int[words.length];
        int[] lens = new int[words.length];
        // 预处理
        for (int i = 0; i < words.length; i++) {
            int bitmarks = 0;
            for (char c : words[i].toCharArray()) {
                bitmarks |= 1 << (c - 'a');
            }
            marks[i] = bitmarks;
            lens[i] = words[i].length();
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((marks[i] & marks[j]) == 0) {
                    result = Math.max(result, lens[i] * lens[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution318 solution318 = new Solution318();
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(solution318.maxProduct1(words));
    }

}