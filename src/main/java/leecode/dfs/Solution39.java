package leecode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/combination-sum/
 * 组合总和
 * @author: xwy
 * @create: 2021年08月12日16:42:26
 **/

public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        // 配合 begin 用于去重,保证数字是有小到大的顺序选择的
        Arrays.sort(candidates);
        dfs(0, target, candidates, nums, lists);
        return lists;
    }

    /**
     * @param begin      从哪个位置的数开始选取(用于去重,保证数字是有小到大的顺序选择的)
     * @param remain     还剩多少凑够 target
     * @param candidates
     * @param nums
     * @param lists
     */
    private void dfs(int begin, int remain, int[] candidates, List<Integer> nums, List<List<Integer>> lists) {

        if (remain == 0) {
            lists.add(new ArrayList<>(nums));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (remain < candidates[i]) return;
            nums.add(candidates[i]);
            dfs(i, remain - candidates[i], candidates, nums, lists);
            nums.remove(nums.size() - 1);
        }
    }

}