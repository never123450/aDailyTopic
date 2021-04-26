package leecode;

import java.util.Arrays;

/**
 * @description: https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * 在D天内送达包裹的能力
 * @projectName:dataStructure
 * @see:leecode
 * @author:xwy
 * @createTime:2021/4/26 21:53
 * @version:1.0
 */
public class Solution1001 {
    public int shipWithinDays(int[] weights, int D) {
        // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution1001 solution1001 = new Solution1001();
        int[] weights = {1,2,3,4,5,6,7,8,9,1};
        int D = 5;
        int i = solution1001.shipWithinDays(weights, D);
        System.out.println(i);
    }
}
