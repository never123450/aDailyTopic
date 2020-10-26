package leecode.string;

/**
 * @description: https://leetcode-cn.com/problems/long-pressed-name/
 * 长按键入
 * @author: xwy
 * @create: 13:09 2020/10/22
 **/

public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && typed.charAt(j) == name.charAt(i)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length() ;
    }

    public static void main(String[] args) {
        Solution925 solution925 = new Solution925();
        boolean longPressedName = solution925.isLongPressedName("alex", "aaleex");
        System.out.println(longPressedName);
    }
}