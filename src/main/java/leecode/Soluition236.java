package leecode;

/**
 * @description: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * 二叉树的最近公共祖先
 * @author: xwy
 * @create: 10:29 下午 2020/9/14
 **/

public class Soluition236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode lett = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (lett != null && right != null) return root;
        return (lett != null) ? lett : right;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}