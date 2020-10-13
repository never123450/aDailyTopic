package leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode-cn.com/problems/sliding-window-maximum/
 * 滑动窗口的最大值  (双端队列  动态规划)
 * @author: xwy
 * @create: 21:03 2020/10/13
 **/

public class Solution239 {

    // 双端队列 滑动窗口
    // peek : 取值(偷偷瞥一眼)
    // poll : 删除(削)
    // offer : 添加(入队)
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1) return null;
        if (k == 1) return nums;
        int[] maxes = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 删除 nums[队尾] <= nums[i]
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 将 i 加入队尾
            deque.offerLast(i);
            // 检查窗口的索引是否合理
            int w = i - k + 1;
            if (w < 0) continue;
            // 检查队头的合法性
            if (deque.peekFirst() < w) {
                // 队头不合法(不在滑动窗口索引范围内
                deque.pollFirst();
            }

            // 设置窗口的最大值
            maxes[w] = nums[deque.peekFirst()];
        }
        return maxes;
    }
}