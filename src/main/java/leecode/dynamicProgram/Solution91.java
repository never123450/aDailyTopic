package leecode.dynamicProgram;

/**
 * @description: https://leetcode-cn.com/problems/decode-ways/
 * 解码方法
 * @author: xwy
 * @create: 下午1:38 2021/4/21
 **/

public class Solution91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }

            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10) + (s.charAt(i - 1) - '0') <= 26) {

                System.out.println("i = " + i);
                System.out.println("s.charAt(i - 2) = " + s.charAt(i - 2));
                System.out.println("(s.charAt(i - 2) - '0') * 10) = " + (s.charAt(i - 2) - '0') * 10);
                System.out.println("(s.charAt(i - 1) - '0') = " + (s.charAt(i - 1) - '0'));

                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        System.out.println(solution91.numDecodings("12"));
    }
}