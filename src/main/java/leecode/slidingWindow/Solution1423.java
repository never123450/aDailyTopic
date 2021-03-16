package leecode.slidingWindow;

/**
 * @description: https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * 可获得的最大点数
 * @author: xwy
 * @create: 22:53 2021/2/6
 **/

public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += cardPoints[i];
        }
        int m = sum;
        for (int i = 0; i < k; ++i) {
            sum += cardPoints[cardPoints.length - 1 - i] - cardPoints[k - 1 - i];
            m = sum > m ? sum : m;
        }
        return m;
    }


    public int maxScore1(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        System.out.println("n: " + n);
        for (int j = n - 1; j >= n - k; j--) {
            sum += cardPoints[j];
        }
        int res = sum;
        System.out.println(sum);
        for (int i = 0; i < k; i++) {
            if (n - k + i >= 0){
                sum = sum - cardPoints[n - k + i] + cardPoints[i];
                System.out.println("sum: " + sum + " out: " + cardPoints[n - k + i] + "   in: " + cardPoints[i] + "   i: " + i);
            }else {
                return res;
            }
            res = sum > res ? sum : res;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution1423 solution1423 = new Solution1423();
//        int [] cardPoints = {2,2,2}; int k = 2;
//        int [] cardPoints = {1,2,3,4,5,6,1}; int k = 3;
//        int [] cardPoints = {9,7,7,9,7,7,9}; int k = 7;
//        int [] cardPoints = {1,1000,1}; int k = 1;
        int [] cardPoints = {1,79,80,1,1,1,200,1}; int k = 3;
//        int [] cardPoints = {96,90,41,82,39,74,64,50,30}; int k = 8;
        int i = solution1423.maxScore1(cardPoints, k);
        System.out.println(i);
    }


}