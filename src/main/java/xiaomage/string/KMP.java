package xiaomage.string;

/**
 * @description: KMP 算法
 * @author: xwy
 * @create: 9:59 PM 2020/9/1
 **/

public class KMP {

    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;

        // next 表
        int[] next = next2(pattern);


        int pi = 0, ti = 0;
        while (pi < plen && ti < tlen) {
            if (pi<0 || textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;
            } else {
                pi = next[pi];
            }
        }
        return (pi == plen) ? (ti - pi) : -1;

    }

    private static int[] next(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        int i = 0;
        next[0] = -1;
        int n = -1;
        int iMax = chars.length - 1;
        // n = next[i]
        while (i < iMax) {
            if (n < 0 || chars[i] == chars[n]) {
                next[++i] = n + 1;
            } else {
                n = next[n];
            }
        }
        return next;
    }

    private static int[] next2(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        int i = 0;
        next[0] = -1;
        int n = -1;
        int iMax = chars.length - 1;
        // n = next[i]
        while (i < iMax) {
            if (n < 0 || chars[i] == chars[n]) {
                ++i;
                ++n;
                if (chars[i] == chars[n]){
                    next[i] = next[n];
                }else {
                    next[i] = n;
                }
            } else {
                n = next[n];
            }
        }
        return next;
    }

}