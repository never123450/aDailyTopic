package leecode.noClassify;

import java.util.Arrays;

/**
 * @description: 会议室 (会员才能看)
 * 给定一个会议时间安排的数组,每个会议时间都包括开始时间和结束时间[[s1,e1],[s2,e2]......](si<ei),
 * 请你判断一个人是否可以参加全部会议
 * @author: xwy
 * @create: 11:29 上午 2020/10/3
 **/

public class Solution252 {

    public boolean canAttendMettings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return false;

        // 按照会议的开始时间,从小到大排序
        Arrays.sort(intervals, (m1, m2) -> {
            return m1[0] - m2[0];
        });

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }

}