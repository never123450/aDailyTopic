package leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description: https://leetcode-cn.com/problems/contains-duplicate-ii/
 * <p>
 * 练习：217
 * @author: xwy
 * @create: 4:04 PM 2020/3/4
 **/

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])){
                return true;
            }
            // 保持record中最多有k个元素
            record.add(nums[i]);
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }

        }
        return false;
    }
}