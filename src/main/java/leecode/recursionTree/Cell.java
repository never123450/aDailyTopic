package leecode.recursionTree;

/**
 * @description: 细胞分裂问题：1个细胞的生命周期是3h，1h分裂一次，求n h后，容器有多少细胞？
 * @author: xwy
 * @create: 10:30 AM 2020/5/9
 **/

public class Cell {

    public static int func(int hour) {

        if (hour == 0) return 1;

        if (hour == 1) return 2;

        if (hour == 2) return 3;

        if (hour == 3) return 7;

        return 2 * func(hour - 1) - func(hour - 3);

    }

    public static void main(String[] args) {
        System.out.println(Cell.func(4));
    }

}