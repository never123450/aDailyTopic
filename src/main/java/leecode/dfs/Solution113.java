package leecode.dfs;

import leecode.noClassify.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/path-sum-ii/
 * 路径总和 II
 * @author: xwy
 * @create: 2021年08月12日16:17:13
 **/

public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        dfs(root, sum, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(TreeNode node, int remain, List<Integer> nums, List<List<Integer>> lists) {
        if (node == null) return;
        remain -= node.val;
        nums.add(node.val);
        // remain = 0不代表结束了,后面有可能正负抵消
        if (node.left == null && node.right == null) {
            if (remain == 0) lists.add(new ArrayList<>(nums));
        } else {
            dfs(node.left, remain, nums, lists);
            dfs(node.right, remain, nums, lists);
        }
        nums.remove(nums.size() - 1);
    }
}