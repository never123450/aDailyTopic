package leecode.noClassify;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/daily-temperatures/
 * 每日温度
 * Solution654 同种题目
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

    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] result = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 动态规划 (倒推法)
     * <p>
     * 对于 每一个i,一开始令j=i+1;
     * 1.如果T[i]<T[j],那么value[i]=j-i,然后 i--
     * 2.如果T[i]==T[j],那么value[i]=value[j]+j-i,然后 i--
     * 如果value[j]==0,value[i]=0,i--
     * 如果value[j]!=0,value[i]=value[j]+j-i
     * 3.如果T[i]>T[j]
     * 如果 value[j]==0 ,value[i]=0,i--
     * 如果 value[j]!=0 ,j=j+value[j] 重新进入 1
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] values = new int[T.length];

        for (int i = T.length - 2; i >= 0; --i) {
            int j = i + 1;
//            while (true) {
//                if (T[i] < T[j]) {
//                    values[i] = j - i;
//                    break;
//                } else {
//                    if (values[j] == 0) {
//                        values[i] = 0;
//                        break;
//                    } else if (T[i] == T[j]) {
//                        values[i] = values[j] + j - i;
//                        break;
//                    } else {
//                        j = j + values[j];
//                    }
//                }
//            }

            // 简化
            while (true) {
                if (T[i] < T[j]) {
                    values[i] = j - i;
                    break;
                } else if (values[j] == 0) {
                    values[i] = 0;
                    break;
                }
                j = j + values[j];
            }
        }
        return values;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 solution739 = new Solution739();

        int[] ints = solution739.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));

        int[] ints1 = solution739.dailyTemperatures1(temperatures);
        System.out.println(Arrays.toString(ints1));
    }
}