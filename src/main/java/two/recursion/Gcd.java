package two.recursion;

/**
 *
 * @description: 最大公约数
 *
 * @author: xwy
 *
 * @create: 10:20 PM 2020/7/6
**/

public class Gcd {

    //欧几里得 定理：
        //2个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数

    public int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            System.out.println("m:" + m);
            System.out.println("n:" + n);
            System.out.println("m % n:" + m % n);
            return gcd(n, m % n);
        }
    }


    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        int x = gcd.gcd(99, 55);
        System.out.println("最大公约数：" + x);
    }
}
