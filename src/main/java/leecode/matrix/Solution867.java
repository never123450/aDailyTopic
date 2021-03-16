package leecode.matrix;

/**
 * @description: https://leetcode-cn.com/problems/transpose-matrix/
 * 867. 转置矩阵
 * @author: xwy
 * @create: 下午6:18 2021/2/25
 **/

public class Solution867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution867 solution867 = new Solution867();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] ints = solution867.transpose(matrix);
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