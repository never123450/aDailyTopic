package xiaomage.string;

/**
 * @description: 字符串匹配 蛮力
 * @author: xwy
 * @create: 7:11 PM 2020/9/1
 **/

public class BruteForce01 {

    /**
     * 暴力解法
     *
     * @param text
     * @param pattern
     * @return
     */
    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;

        int pi = 0, ti = 0;
        while (pi < plen && ti < tlen) {
            if (textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;
            } else {
                ti = ti - pi + 1;
//                ti-=pi-1;
                pi = 0;
            }
        }
        return (pi == plen) ? (ti - pi) : -1;

    }

    public static int indexOf2(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;

        int pi = 0, ti = 0;
        // ti-pi 文本串正在匹配的子串的开始索引
        // tlen - plen 开始索引的临界值
        while (pi < plen && ti - pi <= tlen - plen) {
            if (textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;
            } else {
                ti -= pi - 1;
                pi = 0;
            }
        }
        return (pi == plen) ? (ti - pi) : -1;
    }


    public static int indexOf3(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;

        int tiMax = tlen - plen;
        for (int ti = 0; ti <= tiMax; ti++) {
            int pi = 0;
            for (; pi < plen; pi++) {
                if (textChars[ti + pi] != patternChars[pi]) break;
            }
            if (pi == plen) return ti;
        }
        return -1;
    }

}