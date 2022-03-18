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

    /**
     * 递归
     * 去以 root 为根节点的二叉树中查找 p,q 的最近公共祖先
     * ① 如果 p,q 同时存在于这颗二叉树中,就能成功返回他们的最近公共祖先
     * ② 如果 p,q 都不存在于这颗二叉树中,返回 null
     * ③ 如果只有 p 存在于这颗二叉树中,返回 p
     * ④ 如果只有 q 存在于这颗二叉树中,返回 q
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

}