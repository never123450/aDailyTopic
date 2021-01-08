package leecode.noClassify;

/**
 * @description: https://leetcode-cn.com/problems/path-sum-iii/submissions/
 * @author: xwy
 *
 * 练习：98 450 230 236
 * @create: 11:38 AM 2020/3/12
 **/

public class Solution235 {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;

    }

}