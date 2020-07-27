package two.lcs.queen;

/**
 * @description: 八皇后问题
 * @author: xwy
 * @create: 9:41 PM 2020/7/8
 **/

public class Queen {
    public static int num = 0;//累计方案
    public static final int MAXQUEEN = 8;
    public static int[] cols = new int[MAXQUEEN];//定义clos数组，表示8列棋子皇后摆放的位置

    /**
     * @param n 填第n列的皇后
     */
    public void getCount(int n) {
        boolean[] rows = new boolean[MAXQUEEN];//记录每个方格是否可以填
        for (int m = 0; m < n; m++) {
            rows[cols[m]] = true;
            int d = n - m;//斜对角
            //正斜方向
            if (cols[m] - d >= 0) {
                rows[cols[m] - d] = true;
            }
            //反斜方向
            if (cols[m] + d <= (MAXQUEEN - 1)) {
                rows[cols[m] + d] = true;
            }
        }
        //到此知道了哪些位置不能放皇后
        for (int i = 0; i < MAXQUEEN; i++) {
            if (rows[i]) {
                //不能放
                continue;
            }
            cols[n] = i;
            //下面可能还有合法位置
            if (n < MAXQUEEN - 1) {
                getCount(n + 1);
            } else {
                //找到完整的方案
                num++;
                printQueen();
            }
            //
        }
    }

    private void printQueen() {
        System.out.println("第" + num + "种方案");
        for (int i = 0; i < MAXQUEEN; i++) {
            for (int j = 0; j < MAXQUEEN; j++) {
                if (i == cols[j]) {
                    System.out.print("0 ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.getCount(0);
    }
}
