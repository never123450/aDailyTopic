package leecode.greedy;

/**
 * @description: https://leetcode.cn/problems/lemonade-change/  柠檬水找零
 * @projectName:dataStructure
 * @see:leecode.greedy
 * @author:xwy
 * @createTime:2022年7月22日16:03:25
 * @version:1.0
 */
public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int fiveNums = 0;
        int tenNums = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNums++;
            } else if (bills[i] == 10) {
                if (fiveNums > 0) {
                    fiveNums--;
                    tenNums++;
                } else {
                    return false;
                }
            } else {
                if (fiveNums > 0 && tenNums > 0) {
                    fiveNums--;
                    tenNums--;
                } else if (fiveNums >= 3) {
                    fiveNums -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution860 solution860 = new Solution860();
        int[] bills = new int[]{5, 5, 5, 20};
        boolean b = solution860.lemonadeChange(bills);
        System.out.println(b);
    }
}
