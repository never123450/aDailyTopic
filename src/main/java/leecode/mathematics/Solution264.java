package leecode.mathematics;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @description: https://leetcode-cn.com/problems/ugly-number-ii/
 * 丑数②
 * @author: xwy
 * @create: 下午4:12 2021/4/12
 **/

public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}