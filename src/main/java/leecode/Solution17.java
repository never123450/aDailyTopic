package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 手机输入数字，返回字母的组合
 * 回溯
 * <p>
 * 练习：93 131
 * @author: xwy
 * @create: 8:50 PM 2020/3/16
 **/

public class Solution17 {

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return output;
        }
        this.findCombination(digits, 0, "");

        return output;
    }


    List<String> output = new ArrayList<>();

    // s中保存了此时从digists[0...index-1]翻译得到的一个字母字符串
    // 寻找和digists[index]匹配的字母，获得digists[0...index]翻译得到的解  23
    void findCombination(String digists, int index, String s) {

        System.out.println(index + ":" + s);
        if (index == digists.length()) {
            // 保存s
            output.add(s);
            return;
        }
        char c = digists.charAt(index);//2
        String letters = letterMap[c - '0'];//abc
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digists, index + 1, s + letters.charAt(i));
        }

    }

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };


    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> res = solution17.letterCombinations("23");

    }

}