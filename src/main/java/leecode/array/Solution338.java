package leecode.array;

/**
 * @description: https://leetcode-cn.com/problems/counting-bits/
 * 比特位计数
 * @author: xwy
 * @create: 下午3:59 2021/3/16
 **/

public class Solution338 {

    /**
     * 看完答案后一脸懵，是我想的太简单了么。。。0～3 是两位，分别是00，01，10，10，11，然后 4 到 7 是三位，
     * 分别是100，101，110，111，这不就是前面多了个 1 嘛！ 直接相加就可以了。。后面的以此类推即可
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {

        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        int multi = 1;
        for (int i = 2; i <= num; i++) {
            if (multi * 2 == i) {
                res[i] = 1;
                multi *= 2;
            } else {
                res[i] = 1 + res[i - multi];
            }
        }
        return res;

    }


    public static void main(String[] args) {
        Solution338 solution338 = new Solution338();
        int[] ints = solution338.countBits(5);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }


}