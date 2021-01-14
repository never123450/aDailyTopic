package leecode.mathematics;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 * 可被 5 整除的二进制前缀
 * @author: xwy
 * @create: 16:11 2021/1/14
 **/

public class Solution1018 {


    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> b = new ArrayList<>();
        long num = 0;
        for (int i = 0; i < A.length; i++) {
            num = (num * 2 + A[i]);
            // 超出范围
            System.out.println(num);
            b.add(num % 5 == 0 || num % 5 == 5);
        }
        return b;
    }

    public List<Boolean> prefixesDivBy51(int[] A) {

        List<Boolean> b = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num = (num * 2 + A[i]) % 5;
            b.add(num == 0 || num == 5);
        }
        return b;
    }


    public static void main(String[] args) {

        Solution1018 solution1018 = new Solution1018();
        int A[] = new int[]{1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0};
        System.out.println(solution1018.prefixesDivBy5(A));
        System.out.println(solution1018.prefixesDivBy51(A));

    }

    /**
     * 二级制转十进制
     *
     * @param A
     * @return
     */
    private int TwoToTen(int[] A) {
        // 110 = 1*2*2 + 1*2 + 0
        int result = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            System.out.println("A.length - 1 - i: " + (A.length - 1 - i));
            System.out.println("Math.pow(2, (A.length - 1 - i)): " + Math.pow(2, (A.length - 1 - i)));
            System.out.println("A[i]: " + A[i]);
            result += A[i] * Math.pow(2, (A.length - 1 - i));
        }
        return result;
    }
}