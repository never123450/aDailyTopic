package leecode.mathematics;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode-cn.com/problems/clumsy-factorial/
 * @author: xwy
 * @create: 下午6:44 2021/4/1
 **/

public class Solution1006 {
    /**
     * 栈
     *
     * @param N
     * @return
     */
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;

        int index = 0;
        // 乘除运算先计算放入栈中,加减运算直接放入栈中
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 执行加减运算
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    /**
     * 按顺序执行 5*(5-1)/(5-2)+(5-3)-(5-4)
     *
     * @param N
     * @return
     */
    public int clumsy1(int N) {
        if (N <= 2) return N;
        if (N == 3) return 6;
        int sum = N * (N - 1) / (N - 2) + (N - 3);
        N -= 4;
        while (N >= 4) {
            sum += (-N * (N - 1) / (N - 2) + (N - 3));
            N -= 4;
        }
        return sum - clumsy1(N);
    }

    public static void main(String[] args) {
        Solution1006 solution1006 = new Solution1006();
        int n = 9;
        System.out.println(solution1006.clumsy1(n));
        System.out.println(solution1006.clumsy(n));
    }

}