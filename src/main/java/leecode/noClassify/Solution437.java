package leecode.noClassify;

/**
 * @description: https://leetcode-cn.com/problems/path-sum-iii/
 * <p>
 * 路径总和为某个值的路径总数
 * @author: xwy
 * @create: 11:19 AM 2020/3/12
 **/

public class Solution437 {

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

    public int pathSum(TreeNode root, int sum) {

        if (root == null)
            return 0;

        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    private int findPath(TreeNode node, int num) {
        if (node == null)
            return 0;

        int res = 0;
        if (node.val == num)
            res += 1;

        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);

        return res;
    }

}