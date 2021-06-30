package leecode.noClassify;

import leecode.Solution1001;

/**
 * @description: 168. Excel表列名称
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * @projectName:dataStructure
 * @see:leecode.noClassify
 * @author:xwy
 * @createTime:2021/6/30 22:29
 * @version:1.0
 */
public class Solution168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
//            columnNumber--;
            sb.append((char) (columnNumber % 26  + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution168 solution168 = new Solution168();
        String s = solution168.convertToTitle(26);
        System.out.println(s);
    }
}
