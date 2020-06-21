package leecode.binarySearch;

/**
 * @description: 平方根
 * 牛顿迭代法 二分查找法
 * @author: xwy
 * @create: 10:26 AM 2020/4/24
 **/

public class Solution69 {
    public int mySqrt(int x) {
//        return (int) Math.pow(x,0.5);

        return binarySqrt(x);

    }

    /*
    二分查找
     */
    public int binarySqrt(int x) {
        if (x < 2)
            return x;

        long num;
        int left = 2, right = x/2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            num = (long) mid * mid;
            if (num > x) {
                right = mid - 1;
            } else if (num < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;



    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        System.out.println(solution69.mySqrt(2147395599));

        int b = 2147395599;
        long a =(long) b*b;
        System.out.println(a);
    }
}