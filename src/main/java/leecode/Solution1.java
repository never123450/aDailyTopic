package leecode;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/two-sum/
 * @author: xwy
 * <p>
 * 练习：15，18，16
 * @create: 6:23 PM 2020/3/3
 **/

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int{i,j};
//                }
//            }
//        }
//        return null;


        // -------------------------------------------
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int x = target - nums[i];
//            if (map.containsKey(x) && map.get(x) != i) {
//                return new int[] {i,map.get(x)};
//            }
//        }
//
//        return null;


        // ------------------------------------------------
        if (nums == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) return new int[]{idx, i};
            map.put(nums[i], i);
        }
        return null;
        // ------------------------------------------------

    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {2, 5, 5, 11};
        int[] ints = solution1.twoSum(nums, 10);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}