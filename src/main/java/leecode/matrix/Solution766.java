package leecode.matrix;

/**
 * @description: https://leetcode-cn.com/problems/toeplitz-matrix/
 * 766. 托普利茨矩阵
 * @author: xwy
 * @create: 下午6:51 2021/2/25
 **/

public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {

        int diagonal = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i==j){
                    if (matrix[i][j] != diagonal){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution766 solution766 = new Solution766();
        int[][] matrix = {{11,74,0,93},{40,11,74,7}};
        boolean isToeplitzMatrix = solution766.isToeplitzMatrix(matrix);
        System.out.println(isToeplitzMatrix);
    }
}