package xiaomage.string;


import xiaomage.Asserts;

/**
 * @description:
 * @author: xwy
 * @create: 7:12 PM 2020/9/1
 **/

public class Main {

    public static void main(String[] args) {
        Asserts.test(KMP.indexOf("Hello World", "or") == 7);
        Asserts.test(KMP.indexOf("Hello World", "d") == 10);
        Asserts.test(KMP.indexOf("Hello World", "H") == 0);
        Asserts.test(KMP.indexOf("Hello World", "yyy") == -1);

    }
}