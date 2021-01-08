package leecode.noClassify;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/generate-parentheses/
 * 括号生成
 * @author: xwy
 * @create: 3:36 下午 2020/9/20
 **/

public class Solution22 {

    /*
    1.当左括号,右括号的数量一样时,只能选择左括号
    什么情况可以选择左括号?
    只要左括号的数量>0

    什么情况下可以选择右括号
    右括号的数量>0 && 右括号的数量!=左括号的数量
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0) return new ArrayList<>();
        if (n == 0) {
            list.add("");
            return list;
        }
        dfs(0, n, n, new char[n << 1], list);
        return list;
    }

    /**
     * @param idx         搜索的层号
     * @param leftRemain  左括号的剩余数量
     * @param rightRemain 右括号的剩余数量
     * @param string      用来存放每一层的选择
     * @param list
     */
    private void dfs(int idx, int leftRemain, int rightRemain, char[] string, List<String> list) {
        if (idx == string.length) {
            list.add(new String(string));
            return;
        }

        // 枚举这一层所有可能的选择
        // 选择一种可能之后,进入下一层搜索
        // 选择左括号,然后进入下一层搜索
        if (leftRemain > 0) {
            string[idx] = '(';
            dfs(idx + 1, leftRemain - 1, rightRemain, string, list);
        }

        // 选择右括号,然后进入下一层搜索
        if (rightRemain > 0 && rightRemain != leftRemain) {
            string[idx] = ')';
            dfs(idx + 1, leftRemain, rightRemain - 1, string, list);
        }
    }

}