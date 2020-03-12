package leecode;

/**
 * @description: https://leetcode-cn.com/problems/path-sum/
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * <p>
 * 练习：404 111
 * @author: xwy
 * @create: 11:58 AM 2020/3/11
 **/

public class Solution112 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;

        sum = sum-root.val;

        if (root.left == null && root.right==null){
            return sum == 0;
        }

        return (hasPathSum(root.left,sum) || hasPathSum(root.right,sum));

    }
}