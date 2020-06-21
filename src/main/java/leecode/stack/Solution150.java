package leecode.stack;

import java.util.Stack;

/**
 * @description: 逆波兰表达式求值
 * <p>
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author: xwy
 * @create: 5:33 PM 2020/4/29
 **/

public class Solution150 {
    public int evalRPN(String[] tokens) {

        Stack stack = new Stack();
        Integer a, b;
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                a = (int) stack.pop();
                b = (int) stack.pop();
                stack.push(a + b);
            } else if ("-".equals(tokens[i])) {
                a = (int) stack.pop();
                b = (int) stack.pop();
                stack.push(b - a);
            } else if ("*".equals(tokens[i])) {
                a = (int) stack.pop();
                b = (int) stack.pop();
                stack.push(a * b);
            } else if ("/".equals(tokens[i])) {
                a = (int) stack.pop();
                b = (int) stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return (int) stack.pop();

    }

    public static void main(String[] args) {

        String[] tockes = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Solution150 solution150 = new Solution150();
        System.out.println(solution150.evalRPN(tockes));

    }
}