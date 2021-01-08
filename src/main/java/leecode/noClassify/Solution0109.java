package leecode.noClassify;

/**
 * @description: https://leetcode-cn.com/problems/string-rotation-lcci/
 * 字符串轮转  自己+自己,是否包含
 * @author: xwy
 * @create: 18:25 2020/10/15
 **/

public class Solution0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        Solution0109 solution0109 = new Solution0109();
        boolean flipedString = solution0109.isFlipedString("aba", "bab");
        System.out.println(flipedString);
    }
}