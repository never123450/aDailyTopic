package leecode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 448. 找到所有数组中消失的数字
 * @projectName:dataStructure
 * @see:leecode.array
 * @author:xwy
 * @createTime:17/3/2022 下午10:13
 * @version:1.0
 */
public class Solution448 {
    /**
     * @param
     * @param nums
     * @return java.util.List<java.lang.Integer>
     * @Description 使用额外空间
     * @author xwy
     * @date 18/3/2022 上午8:07
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(i + 1) == null) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * @param
     * @param nums
     * @return java.util.List<java.lang.Integer>
     * @Description 不使用额外空间
     * @author xwy
     * @date 18/3/2022 上午8:08
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution448 solution448 = new Solution448();
        int[] ints = {4, 3, 2, 7, 8, 2, 3, 1};
//        int[] ints = {1, 1};
        List<Integer> disappearedNumbers = solution448.findDisappearedNumbers(ints);
        System.out.println(disappearedNumbers);
    }
}
