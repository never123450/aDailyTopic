package leecode;

/**
 * @description: https://leetcode-cn.com/problems/trapping-rain-water/
 * 接雨水
 * @author: xwy
 * @create: 19:15 2020/10/9
 **/

public class Solution42 {
    /**
     * 当前柱子能不能放水? min(左边柱子最大值,右边柱子最大值) > 当前柱子的高度
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int lastIdx = height.length - 2;
        int[] leftMaxes = new int[height.length];
        for (int i = 1; i <= lastIdx; i++) {
            leftMaxes[i] = Math.max(leftMaxes[i - 1], height[i - 1]);
        }
        int[] rightMaxs = new int[height.length];
        for (int i = lastIdx; i >= 1; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], height[i + 1]);
        }
        // 遍历每一根柱子,看看每一根柱子上能放多少水
        int wather = 0;
        for (int i = 1; i <= lastIdx; i++) {
            // 求出左边最大,右边最大的较小者
            int min = Math.min(leftMaxes[i], rightMaxs[i]);
            // 说明这根柱子不能放水
            if (min <= height[i]) continue;
            // 说明这根柱子能放水
            wather += min - height[i];
        }
        return wather;
    }

    /**
     * 空间复杂度 O(1) 时间复杂度 O(n)
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length-1, lowerMax = 0, water = 0;
        while (l < r) {
            // height[l] ,height[r] 中较小的那个
            int lower = height[height[l] <= height[r] ? l++ : r--];
            // 目前为止遇到的最大的 lower
            lowerMax = Math.max(lowerMax, lower);
            water += lowerMax-lower;
        }
        return water;
    }
}