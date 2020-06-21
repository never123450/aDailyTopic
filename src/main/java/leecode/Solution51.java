package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/n-queens/
 * n皇后问题
 * @author: xwy
 * @create: 7:40 AM 2020/3/18
 **/

public class Solution51 {

    List<List<String>> res = new ArrayList<>();
    List<Boolean> col, dia1, dia2;

    // 尝试在一个n皇后问题中，摆放第index行的皇后位置
    void putQueue(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBorad(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 尝试将第index行的皇后摆放在第i列
            if (!col.get(i) && !dia1.get(index + 1) && !dia2.get(index - i + n - 1)) {
                row.add(i);
                col.set(i, true);
                dia1.set(index + i, true);
                dia2.set(index - i + n - 1, true);
                putQueue(n, index + 1, row);
                col.set(i, false);
                dia1.set(index + i, false);
                dia2.set(index - i + n - 1, false);
                row.remove(i);
            }
            return;
        }
    }

    private List<String> generateBorad(int n, List<Integer> row) {
        List<String> board = new ArrayList<>(n);
//        for (int i=0;i<n;i++)
            //board.get(i).indexOf(row.get(i)) = 'Q';
        return board;
    }

    public List<List<String>> solveNQueens(int n) {
        List<Integer> row = new ArrayList<>();
        col = new ArrayList<>(n);
        dia1 = new ArrayList<>(2 * n - 1);
        dia2 = new ArrayList<>(2 * n - 1);
        putQueue(n, 0, row);
        return res;
    }

}