package leecode.binaryTree;

import leecode.noClassify.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: https://leetcode-cn.com/problems/symmetric-tree/
 * 101. 对称二叉树
 * @projectName:dataStructure
 * @see:leecode.binaryTree
 * @author:xwy
 * @createTime:27/3/2022 下午7:18
 * @version:1.0
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricChild(root.right, root.left);
    }

    private boolean isSymmetricChild(TreeNode right, TreeNode left) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (right.val != left.val) return false;
        return isSymmetricChild(right.left, left.right) && isSymmetricChild(right.right, left.left);
    }


    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        TreeNode right = root.right;
        TreeNode left = root.left;
        if (left == null && right == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if (left == null && right == null) continue;
            if ((left == null || right == null) || left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}
