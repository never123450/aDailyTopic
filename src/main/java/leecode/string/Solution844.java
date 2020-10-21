package leecode.string;

import one.redBlackTree.Solution;

import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/backspace-string-compare/
 * 比较含退格的字符串
 * @author: xwy
 * @create: 21:15 2020/10/19
 **/

public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        return reBuild1(S).equals(reBuild1(T));
    }

    // 平常的方法
    private String reBuild(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '#') {
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            } else {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    // 使用栈
    private String reBuild1(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        String ss = "";
        while (!stack.isEmpty()) {
            ss += stack.pop();
        }
        return ss;
    }

    // ----------双指针------------
    public boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution844 solution844 = new Solution844();
        System.out.println(solution844.backspaceCompare1("ab#c", "ad#c"));
    }

}