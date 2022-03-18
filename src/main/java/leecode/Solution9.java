package leecode;

/**
 * @description: https://leetcode-cn.com/problems/palindrome-number/
 * 回文数
 * @author: xwy
 * @create: 下午3:29 2022/2/21
 **/

public class Solution9 {
    public boolean isPalindrome(int x) {
        if ((x % 10 == 0 && x != 0) || x < 0) {
            return false;
        }

        int revere = 0;
        // x=121
        while (revere < x) {
            int y = x % 10; // 2
            revere = revere * 10 + y; // 12
            x = x / 10; // 1
        }
        return x == revere || (x == revere / 10);
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        boolean palindrome = solution9.isPalindrome(121);
        System.out.println(palindrome);
    }
}