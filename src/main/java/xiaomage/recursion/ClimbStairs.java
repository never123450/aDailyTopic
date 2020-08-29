package xiaomage.recursion;

/**
 * @description: 爬楼梯, 每次只能爬 2 阶或者 1 阶
 * @author: xwy
 * @create: 8:31 AM 2020/8/20
 **/

public class ClimbStairs {

    int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    int climbStairs2(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second;
        }
        return second;
    }


}
