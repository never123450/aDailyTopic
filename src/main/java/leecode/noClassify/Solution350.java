package leecode.noClassify;/// Leetcode 350. Intersection of Two Arrays II
/// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @description:
 * 242 202
 *
 * @author: xwy
 *
 * @create: 6:17 PM 2020/3/3
**/

public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {

//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for(int num: nums1){
//            if(!map.containsKey(num))
//                map.put(num, 1);
//            else
//                map.put(num, map.get(num) + 1);
//        }
//
//        ArrayList<Integer> res = new ArrayList<>();
//        for(int num: nums2){
//            if(map.containsKey(num)){
//                res.add(num);
//                map.put(num, map.get(num) - 1);
//                if(map.get(num) == 0)
//                    map.remove(num);
//            }
//        }
//
//        int[] ret = new int[res.size()];
//        for(int i = 0 ; i < res.size() ; i ++)
//            ret[i] = res.get(i);
//
//        return ret;

        TreeMap map = new TreeMap();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, (int) map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        ArrayList list = new ArrayList();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, (int) map.get(num) - 1);
                if ((int) map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = (int) list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution350 solution349 = new Solution350();
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        int[] intersection = solution349.intersect(num1, num2);
        System.out.println();
        for (int i : intersection) {
            System.out.print(i);
        }
    }
}
