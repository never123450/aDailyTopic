package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/permutations/
 * 给出数组的排列组合
 *
 * 回溯
 * 练习：47 39 40 216 78 90 401
 * @author: xwy
 * @create: 9:01 PM 2020/3/16
 **/

public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return output;
        used = new boolean[nums.length];
        List<Integer> p = new ArrayList<>();
        generatePermutation(nums, 0, p);
        return output;
    }

    List<List<Integer>> output = new ArrayList<>();
    boolean[] used;

    // p中保存了一个有index个元素的排列
    // 向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
    void generatePermutation(int[] nums, int index, List<Integer> p) {

        if (index == nums.length) {
            // 保存s
            output.add(p);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 将nums[i] 放入p中
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                p.remove(nums[i]);
                used[i] = false;
            }
        }

    }


}