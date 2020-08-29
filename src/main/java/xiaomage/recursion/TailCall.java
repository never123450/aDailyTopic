package xiaomage.recursion;

/**
 * @description: 尾递归的优化
 * @author: xwy
 * @create: 6:16 PM 2020/8/20
 **/

public class TailCall {

    public static void main(String[] args) {
        System.out.println(facttorial(4));
    }

    /**
     * 1 * 2 * 3 * 4 * ... * (n - 1) * n
     *
     * @param n
     * @return
     */
    static int facttorial(int n) {
        return facttorial(n, 1);
    }

    static int facttorial(int n, int result) {
        if (n <= 1) return result;
        return facttorial(n - 1, result * n);
    }

//	static int facttorial(int n) {
//		if (n <= 1) return n;
//		return n * facttorial(n - 1);
//	}
}
