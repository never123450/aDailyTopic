package leecode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
 * 爬楼梯
 * <p>
 * 练习：120 64 343
 * @author: xwy
 * @create: 9:28 AM 2020/3/19
 **/

public class Solution70 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * @param
     * @param n
     * @return int
     * @Description 递归
     * @author xwy
     * @date 10/3/2022 下午11:03
     */
    public int climbStairs1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs1(n - 1) + climbStairs(n - 2);
    }


    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * @param
     * @param n
     * @return int
     * @Description 把中间重复的线记录下来
     * @author xwy
     * @date 10/3/2022 下午11:14
     */
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (null != map.get(n)) {
            return map.get(n);
        } else {
            int result = climbStairs2(n - 1) + climbStairs2(n - 2);
            map.put(n, result);
            return result;
        }
    }
}