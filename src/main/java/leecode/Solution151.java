package leecode;

import one.array.Array;

import java.util.*;

/**
 * @description: https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * <p>
 * 反转字符串
 * 相似 58 题
 * @author: xwy
 * @create: 3:27 PM 2020/9/7
 **/

public class Solution151 {

    /**
     * 1.消除多余的空格
     * 2.对整个字符串翻转
     * 3.每个单词都翻转回来
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null) return "";
        char[] chars = s.toCharArray();
        // 1.消除多余的空格
        // 字符串最终的有效长度
        int len = 0;
        // 当前用来存放字符的位置
        int cur = 0;
        // 前一个字符是否为空格
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') { // 非空格字符
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) { // char[i] 是空格字符 , char[i-1] 是非空格字符
                chars[cur++] = ' ';
                space = true;
            }
        }
        len = space ? (cur - 1) : cur;
        if (len <= 0) return "";

        // 2.对整个字符串逆序
        reverse(chars, 0, len);

        // 对每一个单词进行逆序
        // 前一个空格的位置 (-1 哨兵位置)
        int prevSpaceIndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            // i 是空字符的位置
            reverse(chars, prevSpaceIndex + 1, i);
            prevSpaceIndex = i;
        }
        // 翻转最后一个单词
        reverse(chars, prevSpaceIndex + 1, len);

        return new String(chars, 0, len);
    }

    /**
     * 将 [li,ri) 范围的字符串进行逆序
     *
     * @param chars
     * @param li
     * @param ri
     */
    private static void reverse(char[] chars, int li, int ri) {
        ri--;
        while (li < ri) {
            char tmp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li++;
            ri--;
        }

    }

    /**
     * 使用 API
     *
     * @param s
     * @return
     */
    public static String reverseWords2(String s) {
        s = s.trim();
        List<String> worldList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(worldList);
        return String.join(" ", worldList);
    }

    /**
     * 双端队列
     *
     * @param s
     * @return
     */
    public static String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') ++left;

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') --right;

        Deque<String> d = new ArrayDeque();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                // 移除 string
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

    public static void main(String[] args) {
        System.out.println(Solution151.reverseWords3(" hello    world   "));
    }

}