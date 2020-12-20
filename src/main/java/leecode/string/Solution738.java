package leecode.string;

/**
 * @description: https://leetcode-cn.com/problems/monotone-increasing-digits/
 * 单调递增的数字
 * @author: xwy
 * @create: 18:59 2020/12/19
 **/

public class Solution738 {

    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));

    }

    public int monotoneIncreasingDigits1(int N) {
        int ones = 111111111;
        int res = 0;
        for(int i=0;i<9;i++){
            while(res+ones>N){
                ones/=10;
            }
            res += ones;
            if(ones==0)
                break;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution738 solution738 = new Solution738();
        int i = solution738.monotoneIncreasingDigits1(15323);
        System.out.println(i);

    }

}