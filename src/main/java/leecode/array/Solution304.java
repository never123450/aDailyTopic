package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * 二维区域和检索 - 矩阵不可变
 * @author: xwy
 * @create: 下午3:03 2021/3/16
 **/

public class Solution304 {

    int[][] matrix;

    public Solution304(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */