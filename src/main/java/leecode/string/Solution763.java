package leecode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/partition-labels/
 * 划分字母区间
 * @author: xwy
 * @create: 13:52 2020/10/23
 **/

public class Solution763 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int end = 0;
        int tmpEnd = 0;
        int i = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            for (int j = i; j < S.length(); j++) {
                if (c == S.charAt(j)) {
                    tmpEnd = j; //该片段的 tmpEnd >= end
                    end = Math.max(tmpEnd, end);
                }
            }
            // i 后面那个是否被包含于前面的字符串
            int k = end;
            while (k < S.length()-1) {
                k++;
                String stmp = S.substring(i, end + 1);
                if (stmp.contains(String.valueOf(S.charAt(k)))) {
                    end = k;
                }
            }
            res.add(end - i + 1);
            i = end + 1;
        }
        return res;
    }

    public List<Integer> partitionLabels1(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i; // 为最后一个相同字母出现的位置
        }
        // ababcbaca cdefegdehijhklij
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        Solution763 solution763 = new Solution763();
        List<Integer> list = solution763.partitionLabels1("ababcbacadefegdehijhklij");
        System.out.println(list.toString());
    }
}