package leecode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 * <p>
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
                if (!stack.isEmpty()) {
                    char pop = (char) stack.pop();
                    if ((c == ')' && pop == '(') || (c == '}' && pop == '{') || (c == ']' && pop == '[')) {
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private HashMap<Character, Character> map = new HashMap<>();

    public Solution20() {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {// 右括号
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (c != map.get(left)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")){
            s = s.replace("{}","");
            s = s.replace("()","");
            s = s.replace("[]","");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid("()}");
        System.out.println(valid);
    }

}