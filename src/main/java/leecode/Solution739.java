package leecode;

import java.util.Stack;

/**
 * @description: 每日温度
 * @author: xwy
 * @create: 4:28 PM 2020/4/29
 **/

public class Solution739 {

    public int[] dailyTemperatures(int[] T) {

        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 solution739 = new Solution739();

        int[] ints = solution739.dailyTemperatures(temperatures);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "   ");
        }
    }
}