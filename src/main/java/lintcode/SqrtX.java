package lintcode;

/**
 * @description: https://www.lintcode.com/problem/sqrtx/note/171333
 * @create: 2019年04月03日10:31:59
 **/

public class SqrtX {

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        // write your code here
        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        return ans;


    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.sqrt(4187));

    }


}