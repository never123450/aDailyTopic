package leecode.dynamicProgram;

/**
 * @description: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * @author: xwy
 * @create: 4:58 下午 2020/9/11
 **/

public class Solution5 {

    /**
     * 动态规划
     * dp[i][j] 表示s[i,j]是否为回文串
     * 1.如果 s[i,j]的长度<=2 , s[i]=s[j] dp[i][j]=true ,s[i]!=s[j] dp[i][j]=false
     * 2.如果 s[i,j]的长度>2 , s[i+1][j-1]是回文串,且s[i]=s[j],dp[i][j]=true
     *
     * 其实是基于暴力法的优化,优化的部分:判断每个串是否为回文串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s == null) return null;
        char[] cs = s.toCharArray();
        if (cs.length == 0) return s;

        boolean[][] dp = new boolean[cs.length][cs.length];
        // 最长回文子串的长度
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;
        // 从下到上
        for (int i = cs.length; i >= 0; i--) {
            // 从左到右
            for (int j = i; j < dp.length; j++) {
                dp[i][j] = (cs[i] == cs[j]) && (j - i <= 1 || dp[i + 1][j - 1]);
                // cs[i,j]的长度
                int len = j - i + 1;
                if (dp[i][j] && len > maxLen) {// 说明 cs[i,j]是回文串
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return new String(cs, begin, maxLen);
    }


    /**
     * 扩展中心
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        // 最长回文子串的长度
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;

        for (int i = cs.length - 2; i >= 1; i--) {
            // 以字符为中心向左右扩展
            int len1 = palindromeLength(cs, i - 1, i + 1);
            int len2 = palindromeLength(cs, i, i + 1);
            len1 = Math.max(len1, len2);
            if (len1 > maxLen) {
                maxLen = len1;
                begin = i - ((maxLen - 1) >> 1);
            }
        }
        // 以 0 号字符右边的间隙为扩展中心的最长回文子串长度是 2
        if (cs[0] == cs[1] && maxLen < 2) {
            // cs[0,1] 就是最长回文子串
            begin = 0;
            maxLen = 2;
        }

        return new String(cs, begin, maxLen);
    }

    /**
     * @param cs
     * @param l
     * @param r
     * @return 从 l 开始向左扫描,从 r 开始向右扫描,获得的最长回文子串的长度
     */
    private int palindromeLength(char[] cs, int l, int r) {
        while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * 扩展中心 2
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        // 最长回文子串的长度
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;
        int i = 0;
        while (i < cs.length) {

            // l向左 r向右扩展
            int l = i - 1;

            // 找到右边第一个不等于 cs[i] 的位置
            int r = i;
            while (++r < cs.length && cs[r] == cs[i]) {
                i = r;

                // l向左 r向右扩展
                while (l >= 0 && r < cs.length) {
                    l++;
                    r++;
                }

                // 扩展结束 cs(l,r) 最大回文长度
                int len = r - ++l;
                if (len > maxLen) {
                    maxLen = len;
                    begin = l;
                }
            }
        }
        return new String(cs, begin, maxLen);
    }


    /**
     * 马拉车(Manacher)
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {

        if (s == null) return null;
        char[] oldCs = s.toCharArray();
        if (oldCs.length <= 1) return s;

        // 预处理
        char[] cs = preprocess(oldCs);

        // 构建 m 数组
        int[] m = new int[cs.length];
        int c = 1, r = 1, lastIdx = m.length - 2;
        int maxLen = 0, index = 0;
        for (int i = 2; i < lastIdx; i++) {
            if (i < r) {
                int li = (c << 1) - i;
                if (i + m[li] <= r) {
                    m[i] = m[li];
                } else {
                    m[i] = r - i;
                }
            }

            // 以 i 为中心,向左右扩展
            while (cs[i + m[i] + 1] == cs[i - m[i] - 1]) {
                m[i]++;
            }

            // 更新 c,r
            if (i + m[i] > r) {
                c = i;
                r = i + m[i];
            }

            // 找出更大的回文子串
            if (m[i] > maxLen) {
                maxLen = m[i];
                index = i;
            }
        }

        int begin = (index - maxLen) >> 1;
        return new String(oldCs, begin, maxLen);
    }

    private char[] preprocess(char[] oldCs) {
        char[] cs = new char[(oldCs.length << 2) + 3];
        cs[0] = '^';
        cs[1] = '#';
        cs[cs.length - 1] = '$';
        for (int i = 0; i < oldCs.length; i++) {
            int inx = (i + 1) << 1;
            cs[inx] = oldCs[i];
            cs[inx + 1] = '#';
        }
        return cs;
    }

}