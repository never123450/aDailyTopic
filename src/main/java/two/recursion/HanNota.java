package two.recursion;

/**
 * @description: 汉诺塔
 * @author: xwy
 * @create: 8:36 PM 2020/7/6
 **/

public class HanNota {
    private int i = 1;

    public void hanNota(int n, char from, char dependOn, char to) {
        if (n == 1) {
            move(1, from, to);
        } else {
            hanNota(n - 1, from, to, dependOn);//第一步：将n-1个盘子从A挪到B
            move(n, from, to);//将这n个盘子从A挪到C
            hanNota(n - 1, dependOn, from, to);//将n-1个盘子从B利用A挪到C
        }
    }

    private void move(int n, char from, char to) {
        System.out.println("第" + i++ + "次 " + from + "------>" + to);
    }

    public static void main(String[] args) {
        HanNota hanNota = new HanNota();
        hanNota.hanNota(2, 'A', 'B', 'C');
    }
}
