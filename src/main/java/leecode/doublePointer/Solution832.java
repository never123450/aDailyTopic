package leecode.doublePointer;

/**
 * @description: https://leetcode-cn.com/problems/flipping-an-image/
 * 翻转图像
 * @author: xwy
 * @create: 下午8:42 2021/2/24
 **/

public class Solution832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                if (A[i][j] == A[i][n - 1 - j]) {
                    A[i][j] ^= 1;
                    A[i][n - 1 - j] ^= 1;
                }
            }
            // 奇数
            if (A[i].length % 2 != 0) {
                A[i][A[i].length / 2] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        // [[1,0,0],[0,1,0],[1,1,1]]
//        int[][] A = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        // [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
        Solution832 solution832 = new Solution832();
        int[][] ints = solution832.flipAndInvertImage(A);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (j == ints[i].length - 1) {
                    System.out.println(ints[i][j]);
                } else {
                    System.out.print(ints[i][j] + " ");
                }

            }
        }
    }
}