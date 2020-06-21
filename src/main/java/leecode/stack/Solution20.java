package leecode.stack;

import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 *
 * 练习：150 71
 * @author: xwy
 * @create: 10:16 AM 2020/3/8
 **/

public class Solution20 {

    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty()){
                    char pop = (char) stack.pop();
                    if ((c==')' && pop =='(') || (c=='}' && pop =='{') || (c==']' && pop =='[')){
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid("()}");
        System.out.println(valid);
    }

}