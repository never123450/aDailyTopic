package leecode.binaryTree;

import leecode.noClassify.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * 二叉树的最近公共祖先
 * @author: xwy
 * @create: 10:29 下午 2020/9/14
 * 2021年08月05日16:52:10
 **/

public class Soluition236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}