package leecode.noClassify;

/**
 * @description: https://leetcode-cn.com/problems/container-with-most-water/
 * 盛水最多的容器
 * @author: xwy
 * @create: 7:18 下午 2020/10/3
 **/

public class Solution11 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1, wather = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                wather = Math.max(wather, (r - l) * height[l]);
                l++;
            } else {
                wather = Math.max(wather, (l - r) * height[r]);
                r--;
            }
        }
        return wather;
    }

    /**
     * 上面的简化
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1, wather = 0;
        while (l < r) {
            int minH = (height[l] <= height[r]) ? height[l++] : height[r--];
            wather = Math.max(wather, minH * (r - l + 1));
//            while (l < r && height[l] <= minH) l++;
//            while (l < r && height[r] <= minH) r--;
        }
        return wather;
    }

    /**
     * 再优化
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1, wather = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                int minH = height[l];
                wather = Math.max(wather, (r - l) * minH);
                while (l < r && height[l] <= minH) l++;
            } else {
                int minH = height[r];
                wather = Math.max(wather, (r - l) * height[r]);
                while (l < r && height[r] <= minH) r--;
            }
        }
        return wather;
    }

    /**
     * 上面的简化
     *
     * @param height
     * @return
     */
    public int maxArea3(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1, wather = 0;
        while (l < r) {
            int minH = Math.min(height[l], height[r]);
            wather = Math.max(wather, minH * (r - l));
            while (l < r && height[l] <= minH) l++;
            while (l < r && height[r] <= minH) r--;
        }
        return wather;
    }

}