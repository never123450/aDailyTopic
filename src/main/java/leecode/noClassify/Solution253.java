package leecode.noClassify;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 会议室2
 * 给定一个会议时间安排的数组,每个会议时间都包括开始时间和结束时间[[s1,e1],[s2,e2]......](si<ei),
 * 为避免会议冲突 ,同时要考虑充分利用会议室资源,请你计算至少需要多少间会议室,才能满足这些会议安排
 * @author: xwy
 * @create: 4:34 下午 2020/10/3
 **/

public class Solution253 {

    /**
     * 最小堆
     *
     * @param intervals
     * @return
     */
    public int minMeetingRoots(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // 按照会议的开始时间,从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(m -> m[0]));

        // 创建一个最小堆(存放每一个会议的结束时间)
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 添加 0 号会议的结束时间
        heap.add(intervals[0][1]);

        // 堆顶的含义:目前占用的会议室中最早结束时间
        for (int i = 0; i < intervals.length; i++) {
            // i 号会议的开始时间 >= 堆顶
            if (intervals[i][0] >= heap.peek()) {
                heap.remove();
            }
            // 将 i 号会议的结束时间加入堆中
            heap.add(intervals[i][1]);
        }

        return heap.size();
    }

    public int minMeetingRoots1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 所有会议的开始时间
        int[] begins = new int[intervals.length];
        // 所有会议的结束时间
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // 排序
        Arrays.sort(begins);
        Arrays.sort(ends);

        int room = 0, endIdx = 0;

        for (int begin : begins) {
            if (begin >= ends[endIdx]) {
                // 能重复利用
                endIdx++;
            } else {
                // 需要新开
                room++;
            }
        }
        return room;
    }

}