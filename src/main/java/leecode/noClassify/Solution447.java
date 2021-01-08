package leecode.noClassify;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/number-of-boomerangs/
 * @author: xwy
 *
 * 练习：149
 *
 * @create: 8:12 PM 2020/3/3
 **/

public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
//        int res = 0;
//        for (int i = 0; i < points.length; i++) {
//            Map<Integer, Integer> record = new HashMap<>();// 距离   距离出现的频率
//            for (int j = 0; j < points.length; j++) {
//                if (record.get(dis(points[i], points[j])) == null) {
//                    record.put(dis(points[i], points[j]), 1);
//                } else {
//                    record.put(dis(points[i], points[j]), record.get(dis(points[i], points[j]) + 1);
//                }
//            }
//        }
        return 0;

    }

    private Integer dis(int[] point, int[] point1) {
        return (point[0] - point1[0]) * (point[0] - point1[0]) + (point[1] - point1[1]) * (point[1] - point1[1]);
    }
}