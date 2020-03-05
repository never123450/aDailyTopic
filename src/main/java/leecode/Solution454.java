package leecode;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/4sum-ii/
 *
 * 练习：49
 *
 * @author: xwy
 * @create: 7:48 PM 2020/3/3
 **/

public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(A[i] + B[j])) {
                    map.put(A[i] + B[j], map.get(A[i] + B[j]) + 1);
                } else {
                    map.put(A[i] + B[j], 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(-C[i] - D[j])) {
                    res+=map.get(-C[i] - D[j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution454 solution454 = new Solution454();
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};
        int i = solution454.fourSumCount(A, B, C, D);
        System.out.println(i);
    }
}