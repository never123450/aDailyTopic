package leecode.BitOperation;

/**
 * @description: https://leetcode.cn/problems/power-of-two/
 * 2的幂
 * @projectName:dataStructure
 * @see:leecode.BitOperation
 * @author:xwy
 * @createTime:2022-07-24 下午9:14
 * @version:1.0
 */
public class Solution231 {
    /**
     * @param
     * @param n
     * @return boolean
     * @Description 常规
     * @author xwy
     * @date 2022-07-24 下午9:30
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 2) {
            if (n % 2 == 1) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    public boolean isPowerOfTwo1(int n) {
        return n>0 && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        Solution231 solution231 = new Solution231();
        boolean powerOfTwo = solution231.isPowerOfTwo1(16);
        System.out.println(powerOfTwo);
    }
}
